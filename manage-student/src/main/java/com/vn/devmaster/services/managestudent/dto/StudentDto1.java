package com.vn.devmaster.services.managestudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto1 {
    private Integer id;
    private String fullName;
    private String firstName;
    private String lastName;
    private String city;
}
