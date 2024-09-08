package com.example.cinema_client.controllers;

import com.example.cinema_client.models.ApiResponse;
import com.example.cinema_client.models.FeedbackDTO;
import com.example.cinema_client.models.IntroduceDTO;
import com.example.cinema_client.models.JwtResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/introduce1")
public class IntroduceController {

    private static final String API_GET_SCHEDULES_FILTER = "http://localhost:8080/api/schedules";
    private static final String API_GET_FEEDBACKS_BY_TYPE = "http://localhost:8080/api/feedbacks/type/schedule";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpSession httpSession;

    @GetMapping
    public String displayIntroducePage(Model model) {

        // Gọi API để lấy danh sách lịch chiếu
        String scheduleUrl = UriComponentsBuilder.fromHttpUrl(API_GET_SCHEDULES_FILTER)
                .toUriString();
        System.out.println("Schedule URL: " + scheduleUrl);
        ResponseEntity<ApiResponse<List<Object[]>>> scheduleResponse = restTemplate.exchange(
                scheduleUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<Object[]>>>() {
                }
        );

        // Xử lý phản hồi và tạo danh sách các đối tượng IntroduceDTO
        List<Object[]> schedules = scheduleResponse.getBody().getResult();
        List<IntroduceDTO> introList = new ArrayList<>();
        for (Object[] scheduleArray : schedules) {
            IntroduceDTO schedule = new IntroduceDTO();
            schedule.setId((Integer) scheduleArray[0]);
            schedule.setMovieName((String) scheduleArray[1]);
            schedule.setSmallImageUrl((String) scheduleArray[2]);  // Gán giá trị cho ảnh
            schedule.setRoomName((String) scheduleArray[3]);
            schedule.setStartDate((String) scheduleArray[4]);
            schedule.setStartTime((String) scheduleArray[5]);
            schedule.setPrice((Double) scheduleArray[6]);
            schedule.setBranchName((String) scheduleArray[7]);
            introList.add(schedule);
        }
        model.addAttribute("introList", introList);

        // Gọi API để lấy Feedback cho Schedule
        ResponseEntity<ApiResponse<List<FeedbackDTO>>> feedbackResponse = restTemplate.exchange(
                API_GET_FEEDBACKS_BY_TYPE,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse<List<FeedbackDTO>>>() {
                }
        );
        List<FeedbackDTO> feedbacks = feedbackResponse.getBody().getResult();

        // Nhóm các feedback theo referenceId (ID của schedule)
        Map<Integer, List<FeedbackDTO>> feedbacksBySchedule = feedbacks.stream()
                .collect(Collectors.groupingBy(FeedbackDTO::getReferenceId));

        // Thêm dữ liệu Schedule và Feedback vào model
        model.addAttribute("feedbacksBySchedule", feedbacksBySchedule);


        JwtResponseDTO jwtResponse = (JwtResponseDTO) httpSession.getAttribute("jwtResponse");
        String token = null;
        if (jwtResponse != null) {
            token = jwtResponse.getAccessToken();

            model.addAttribute("userId", jwtResponse.getId());
            model.addAttribute("jwtResponse", jwtResponse);
            model.addAttribute("token", token);
        } else {
            model.addAttribute("jwtResponse", null);
            model.addAttribute("userid", 0);
        }
        return "introduce";
    }
}
