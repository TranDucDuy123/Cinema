package com.example.cinema_back_end.dtos.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {
    Integer id;
    String name;
    Set<Integer> permissions;
}
