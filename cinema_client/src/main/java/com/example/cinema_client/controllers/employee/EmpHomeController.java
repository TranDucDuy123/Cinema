package com.example.cinema_client.controllers.employee;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.attoparser.dom.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.cinema_client.constants.Api;
import com.example.cinema_client.models.BillDTO;
import com.example.cinema_client.models.JwtResponseDTO;
import com.example.cinema_client.models.TicketDTO;
import java.util.Comparator;
@Controller
@RequestMapping("/employee")
public class EmpHomeController {
	@Autowired
	private RestTemplate restTemplate;
    private static final String API_GET_BILLS = Api.baseURL + "/api/employee/bills";
	private static final String API_GET_TICKETS = Api.baseURL+"/api/employee/tickets";
	@GetMapping
	public String employeeHome(HttpSession session, Model model) {
	    // Lấy access token từ session và thiết lập headers
	    HttpHeaders headers = new HttpHeaders();
	    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	    JwtResponseDTO jwtResponseDTO = (JwtResponseDTO) session.getAttribute("jwtResponse");
	    headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + jwtResponseDTO.getAccessToken());

	    // Gửi request GET để lấy danh sách hóa đơn
	    HttpEntity<?> entity = new HttpEntity<>(headers);
	    ResponseEntity<BillDTO[]> response = restTemplate.exchange(API_GET_BILLS, HttpMethod.GET, entity, BillDTO[].class);
	    BillDTO[] bills = response.getBody();

	    // Lấy thông tin username của tài khoản đăng nhập
	    String loggedInUsername = jwtResponseDTO.getUsername();

	    // Lọc danh sách hóa đơn để chỉ lấy hóa đơn của tài khoản đăng nhập
	    BillDTO[] filteredBills = Arrays.stream(bills)
	                                    .filter(bill -> bill.getUser().getUsername().equals(loggedInUsername))
	                                    .toArray(BillDTO[]::new);

	    // Sắp xếp danh sách hóa đơn đã lọc theo `createdTime` theo thứ tự giảm dần
	    Arrays.sort(filteredBills, Comparator.comparing(BillDTO::getCreatedTime).reversed());
	    // Cập nhật `formattedCreatedTime` cho từng hóa đơn
	  
	    // Đưa danh sách hóa đơn đã lọc và sắp xếp vào model để hiển thị trên giao diện
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for (BillDTO bill : filteredBills) {
            bill.setFormattedCreatedTime(bill.getCreatedTime().format(formatter));
        }

        model.addAttribute("bills", filteredBills);

        return "employee/empbill";
    
	}

	@GetMapping("/viewTickets")
    public String displayTicket(@RequestParam Integer billId ,HttpSession session,Model model){
        //Gắn access token jwt vào header để gửi kèm request
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        JwtResponseDTO jwtResponseDTO = (JwtResponseDTO)session.getAttribute("jwtResponse");
        headers.set(HttpHeaders.AUTHORIZATION,"Bearer "+jwtResponseDTO.getAccessToken());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String urlTemplate = UriComponentsBuilder.fromHttpUrl(API_GET_TICKETS)
                .queryParam("billId", "{billId}")
                .encode()
                .toUriString();
        Map<String,Integer> listRequestParam = new HashMap<>();
        listRequestParam.put("billId", billId);
        TicketDTO[] tickets = null;
        try {
            ResponseEntity<TicketDTO[]> responseTicket = restTemplate.exchange(urlTemplate,HttpMethod.POST,entity,TicketDTO[].class,
            		listRequestParam);
    	    tickets = responseTicket.getBody();
		} catch (Exception e) {
			System.out.println(e);
		}
        model.addAttribute("tickets", tickets);
	  
        return "employee/empview-ticket";
    }
	

}