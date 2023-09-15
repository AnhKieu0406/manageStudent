package com.vn.devmaster.services.managestudent.dto;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
public class StudentDTO {
    @Getter
    private Integer id;
    private String name;
    private String firstName;
    private String lastName;
    private String city;
    private AdressDto adressDto;
    private List<SubjectDto> subjectDtos =new ArrayList<>();
//    private StudentSubjectDto studentSubjectDto;


}
