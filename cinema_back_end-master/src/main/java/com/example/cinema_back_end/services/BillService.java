package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.BillDTO;
import com.example.cinema_back_end.dtos.BookingRequestDTO;

import com.example.cinema_back_end.entities.*;
import com.example.cinema_back_end.repositories.*;
import com.example.cinema_back_end.security.exceptions.AppException;
import com.example.cinema_back_end.security.exceptions.ErrorCode;
import com.example.cinema_back_end.security.repo.IUserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService implements IBillService{
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IBillRepository billRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DiscountRepository discountRepository;

    @Override
    @Transactional
    public void createNewBill(BookingRequestDTO bookingRequestDTO) throws RuntimeException {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Lấy ra lịch
        Schedule schedule = scheduleRepository.findById(bookingRequestDTO.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Lịch không tồn tại"));

        if (schedule.getStartDate().isAfter(date) ||
                (schedule.getStartDate().isEqual(date) && schedule.getStartTime().isAfter(time))) {

            // Lấy người dùng
            User user = userRepository.findById(bookingRequestDTO.getUserId())
                    .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));

            // Tính tổng giá ban đầu
            double totalPrice = 0.0;

            // Đặt ghế và tính giá cho từng ghế
            for (Integer seatId : bookingRequestDTO.getListSeatIds()) {
                Seat seat = seatRepository.findById(seatId)
                        .orElseThrow(() -> new RuntimeException("Ghế không tồn tại"));

                double seatPrice = schedule.getPrice();
                if (seat.isVip()) {
                    seatPrice += 10000; // Thêm giá cho ghế VIP
                }
                totalPrice += seatPrice;

                // Tạo Ticket và lưu vào DB
                Ticket ticket = new Ticket();
                ticket.setSchedule(schedule);
                ticket.setSeat(seat);
                ticket.setQrImageURL("https://example.com/qr-image"); // Thay thế bằng URL thực tế
                ticketRepository.save(ticket);
            }
            // Xử lý mã giảm giá (nếu có)
            if (bookingRequestDTO.getDiscountCode() != null && !bookingRequestDTO.getDiscountCode().isEmpty()) {
                Discount discount = discountRepository.findByCode(bookingRequestDTO.getDiscountCode())
                        .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));

                // Kiểm tra mã giảm giá có hiệu lực không
                if (discount.getIsActive()) {
                    double discountAmount = totalPrice * (discount.getPercentage() / 100); // Tính số tiền giảm
                    totalPrice -= discountAmount; // Cập nhật tổng giá sau khi áp dụng giảm giá
                } else {
                    throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION); // Mã giảm giá hết hạn hoặc không còn hiệu lực
                }
            }


            // Cập nhật tổng giá vào bill và lưu bill
            Bill bill = new Bill();
            bill.setUser(user);
            bill.setCreatedTime(LocalDate.now().atTime(time));
            bill.setPrice(totalPrice); // Tổng giá đã tính theo discount

            // Lưu Bill vào DB
            billRepository.save(bill);

        } else {
            throw new RuntimeException("Lịch chiếu đã kết thúc không thể đặt chỗ ngồi!");
        }
    }

	@Override
	public List<BillDTO> findAll() {
		// TODO Auto-generated method stub
		return billRepository.findAll().stream().map(bill->modelMapper.map(bill, BillDTO.class)).collect(Collectors.toList());
	}

	@Override
	public BillDTO getById(Integer billId) {
		// TODO Auto-generated method stub
		 return modelMapper.map(billRepository.getById(billId),BillDTO.class);
	}	
	

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		billRepository.deleteById(id);
	}

	@Override
	public void update(BillDTO t) {
		// TODO Auto-generated method stub
		
	}
}
