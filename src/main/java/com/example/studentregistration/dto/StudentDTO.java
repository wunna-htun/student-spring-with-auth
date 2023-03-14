package com.example.studentregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String username;

    private String email;

    private String phone;

    public StudentDTO(String email, String password) {
    }
}

