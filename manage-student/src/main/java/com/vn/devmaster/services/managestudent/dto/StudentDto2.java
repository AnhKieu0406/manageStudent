package com.vn.devmaster.services.managestudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto2 {
    private Integer id;
    private String fullName;
    private String city;
    private Integer point;
}
