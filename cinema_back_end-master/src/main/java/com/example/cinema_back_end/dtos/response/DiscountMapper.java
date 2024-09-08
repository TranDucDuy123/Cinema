package com.example.cinema_back_end.dtos.response;

import com.example.cinema_back_end.entities.Discount;

public class DiscountMapper {

    public static DiscountDTO toDTO(Discount discount) {
        return DiscountDTO.builder()
                .id(discount.getId())
                .code(discount.getCode())
                .description(discount.getDescription())
                .percentage(discount.getPercentage())
                .amount(discount.getAmount())
                .startDate(discount.getStartDate())
                .endDate(discount.getEndDate())
                .isActive(discount.getIsActive())
                .build();
    }

    public static Discount toEntity(DiscountDTO discountDTO) {
        Discount discount = new Discount();
        discount.setId(discountDTO.getId());
        discount.setCode(discountDTO.getCode());
        discount.setDescription(discountDTO.getDescription());
        discount.setPercentage(discountDTO.getPercentage());
        discount.setAmount(discountDTO.getAmount());
        discount.setStartDate(discountDTO.getStartDate());
        discount.setEndDate(discountDTO.getEndDate());
        discount.setIsActive(discountDTO.getIsActive());
        return discount;
    }
}
