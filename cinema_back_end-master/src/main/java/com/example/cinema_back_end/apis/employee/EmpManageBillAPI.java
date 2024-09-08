package com.example.cinema_back_end.apis.employee;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema_back_end.dtos.BillDTO;
import com.example.cinema_back_end.services.IBillService;
import com.example.cinema_back_end.services.PDFService;

@RestController
@RequestMapping("/api/employee/bills")
public class EmpManageBillAPI {

    @Autowired
    private IBillService billService;

    @Autowired
    private PDFService pdfService;
    @GetMapping
    public ResponseEntity<List<BillDTO>> getAllBills() {
        return new ResponseEntity<>(billService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBill(@Param("billId") Integer billId) {
        billService.remove(billId);
        return new ResponseEntity<>("Xóa hóa đơn thành công!", HttpStatus.OK);
    }
}
