package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.response.DiscountDTO;
import com.example.cinema_back_end.dtos.response.DiscountMapper;
import com.example.cinema_back_end.entities.Discount;
import com.example.cinema_back_end.security.exceptions.AppException;
import com.example.cinema_back_end.security.exceptions.ErrorCode;
import com.example.cinema_back_end.repositories.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountService {

	@Autowired
	private final DiscountRepository discountRepository;

	public DiscountDTO addDiscount(DiscountDTO discountDTO) {
		// Kiểm tra mã code đã tồn tại
		if (discountRepository.findByCode(discountDTO.getCode()).isPresent()) {
			throw new AppException(ErrorCode.CODE_ALREADY_EXISTS);
		}

		// Thực hiện việc thêm mới discount
		Discount discount = DiscountMapper.toEntity(discountDTO);
		Discount savedDiscount = discountRepository.save(discount);
		return DiscountMapper.toDTO(savedDiscount);
	}

	public List<DiscountDTO> getAllDiscounts() {
		return discountRepository.findAll().stream()
				.map(DiscountMapper::toDTO)
				.collect(Collectors.toList());
	}

	public DiscountDTO getDiscountById(Integer id) {
		Discount discount = discountRepository.findById(id)
				.orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
		return DiscountMapper.toDTO(discount);
	}

	public DiscountDTO updateDiscount(Integer id, DiscountDTO discountDTO) {
		Discount discount = discountRepository.findById(id)
				.orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));

		discount.setCode(discountDTO.getCode());
		discount.setDescription(discountDTO.getDescription());
		discount.setPercentage(discountDTO.getPercentage());
		discount.setAmount(discountDTO.getAmount());
		discount.setStartDate(discountDTO.getStartDate());
		discount.setEndDate(discountDTO.getEndDate());
		discount.setIsActive(discountDTO.getIsActive());

		Discount updatedDiscount = discountRepository.save(discount);
		return DiscountMapper.toDTO(updatedDiscount);
	}

	public void deleteDiscount(Integer id) {
		if (!discountRepository.existsById(id)) {
			throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
		}
		discountRepository.deleteById(id);
	}

	public List<DiscountDTO> getDiscountsByPercent(Double percent) {
		return discountRepository.findByPercentage(percent).stream()
				.map(DiscountMapper::toDTO)
				.collect(Collectors.toList());
	}

	public List<DiscountDTO> getDiscountsBetweenDates(LocalDate startDate, LocalDate endDate) {
		return discountRepository.findByStartDateBetween(startDate, endDate).stream()
				.map(DiscountMapper::toDTO)
				.collect(Collectors.toList());
	}

	public DiscountDTO getDiscountByCode(String code) {
		// Sử dụng Optional và xử lý ngoại lệ nếu không tìm thấy Discount
		Discount discount = discountRepository.findByCode(code)
				.orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));

		// Chuyển đổi Discount sang DiscountDTO bằng DiscountMapper
		return DiscountMapper.toDTO(discount);
	}
}
