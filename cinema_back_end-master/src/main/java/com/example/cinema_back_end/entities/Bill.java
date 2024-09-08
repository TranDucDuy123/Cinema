package com.example.cinema_back_end.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bill")
@NoArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    private LocalDateTime createdTime;

    private double price;  // Tổng giá trị trước khi giảm giá
    private double discountAmount;  // Số tiền được giảm
    private double finalPrice;  // Tổng giá trị sau khi áp dụng giảm giá

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
