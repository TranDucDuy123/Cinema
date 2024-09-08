package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.BillDTO;
import com.example.cinema_back_end.dtos.BookingRequestDTO;
import com.example.cinema_back_end.services.IBillService;
import com.example.cinema_back_end.services.PDFService;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bills")
public class BillApi {
    @Autowired
    private IBillService billService;
    @Autowired
    private PDFService pdfService;
    @PostMapping("/create-new-bill")
    public ResponseEntity<String> createNewBill(@RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            billService.createNewBill(bookingRequestDTO);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>("Bạn đã mua vé xem phim thành công !", HttpStatus.OK);
    }
    @GetMapping("/pdf/{billId}")
    public ResponseEntity<?> downloadBillPDF(@PathVariable int billId) {
        BillDTO billDTO = billService.getById(billId);
        if (billDTO == null) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayInputStream bis;
        try {
            bis = pdfService.generateBillPDF(billDTO);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error generating PDF: " + e.getMessage());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=bill_" + billId + ".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }


}
