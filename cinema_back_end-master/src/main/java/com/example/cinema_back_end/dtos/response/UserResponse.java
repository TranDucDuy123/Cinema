package com.example.cinema_back_end.dtos.response;

import com.example.cinema_back_end.entities.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String username;
    String password;
    String fullName;
    String phone;
    Set<Role> roles;
}
