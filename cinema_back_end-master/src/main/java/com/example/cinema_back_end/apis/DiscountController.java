package com.example.cinema_back_end.apis;

import com.example.cinema_back_end.dtos.request.ApiResponse;
import com.example.cinema_back_end.dtos.response.DiscountDTO;
import com.example.cinema_back_end.security.exceptions.AppException;
import com.example.cinema_back_end.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/admin/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    public ApiResponse<List<DiscountDTO>> getAllDiscounts() {
        List<DiscountDTO> discounts = discountService.getAllDiscounts();
        return ApiResponse.<List<DiscountDTO>>builder()
                .code(200)
                .message("Fetched all discounts successfully")
                .result(discounts)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<DiscountDTO> getDiscountById(@PathVariable Integer id) {
        DiscountDTO discount = discountService.getDiscountById(id);
        return ApiResponse.<DiscountDTO>builder()
                .code(200)
                .message("Fetched discount successfully")
                .result(discount)
                .build();
    }

    @PostMapping
    public ApiResponse<DiscountDTO> createDiscount(@RequestBody DiscountDTO discountDTO) {
        try {
            DiscountDTO createdDiscount = discountService.addDiscount(discountDTO);
            return ApiResponse.<DiscountDTO>builder()
                    .code(201)
                    .message("Discount created successfully")
                    .result(createdDiscount)
                    .build();
        } catch (AppException e) {
            return ApiResponse.<DiscountDTO>builder()
                    .code(400)  // Mã lỗi cho yêu cầu không hợp lệ
                    .message(e.getMessage())  // Thông báo lỗi
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ApiResponse<DiscountDTO> updateDiscount(@PathVariable Integer id, @RequestBody DiscountDTO discountDTO) {
        DiscountDTO updatedDiscount = discountService.updateDiscount(id, discountDTO);
        return ApiResponse.<DiscountDTO>builder()
                .code(200)
                .message("Discount updated successfully")
                .result(updatedDiscount)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDiscount(@PathVariable Integer id) {
        discountService.deleteDiscount(id);
        return ApiResponse.<Void>builder()
                .code(200)
                .message("Discount deleted successfully")
                .build();
    }

    @GetMapping("/by-percent")
    public ApiResponse<List<DiscountDTO>> getDiscountsByPercent(@RequestParam Double percent) {
        List<DiscountDTO> discounts = discountService.getDiscountsByPercent(percent);
        return ApiResponse.<List<DiscountDTO>>builder()
                .code(200)
                .message("Fetched discounts by percentage successfully")
                .result(discounts)
                .build();
    }

    @GetMapping("/between-dates")
    public ApiResponse<List<DiscountDTO>> getDiscountsBetweenDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<DiscountDTO> discounts = discountService.getDiscountsBetweenDates(startDate, endDate);
        return ApiResponse.<List<DiscountDTO>>builder()
                .code(200)
                .message("Fetched discounts between dates successfully")
                .result(discounts)
                .build();
    }
    @GetMapping("/by-code")
    public ApiResponse<DiscountDTO> getDiscountByCode(@RequestParam String code) {
        DiscountDTO discount = discountService.getDiscountByCode(code);
        return ApiResponse.<DiscountDTO>builder()
                .code(200)
                .message("Successfully retrieved discount information")
                .result(discount)
                .build();
    }

}
