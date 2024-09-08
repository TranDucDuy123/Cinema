package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.TicketDTO;
import com.example.cinema_back_end.entities.Ticket;
import com.example.cinema_back_end.repositories.ITicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private ITicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TicketDTO> getTicketsByUserId(Integer userId) {
        return ticketRepository.findTicketsByUserId(userId)
                .stream().map(this::mapToDTOWithAdjustedPrice)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> getTicketsByBillId(Integer billId) {
        return ticketRepository.findTicketsByBill_Id(billId)
                .stream().map(this::mapToDTOWithAdjustedPrice)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> findAll() {
        return ticketRepository.findAll()
                .stream().map(this::mapToDTOWithAdjustedPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Integer id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO getById(Integer id) {
        return mapToDTOWithAdjustedPrice(ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket không tồn tại")));
    }

    @Override
    public void update(TicketDTO t) {
        // Implementation of update logic if needed
    }

    private TicketDTO mapToDTOWithAdjustedPrice(Ticket ticket) {
        TicketDTO dto = modelMapper.map(ticket, TicketDTO.class);

        double basePrice = ticket.getSchedule().getPrice();
        if (ticket.getSeat().isVip()) {
            basePrice += 10000; // Add 10,000 if the seat is VIP
        }

        logger.info("Base price: {}", ticket.getSchedule().getPrice());
        logger.info("Adjusted price for VIP: {}", basePrice);

        dto.setPrice(basePrice);
        return dto;
    }
}
