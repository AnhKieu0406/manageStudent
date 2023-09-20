package com.vn.devmaster.services.managestudent.dto;



import com.vn.devmaster.services.managestudent.domain.StudentSubject;
import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StudentDTO   {

    private Integer id;
    private String fullName;
    private String firstName;
    private String lastName;
    private AdressDto adressDto;
    private List<SubjectDto> subjectDtos;
   private List<StudentSubjectDto> studentSubjectDto;

    public StudentDTO(Integer id, String firstName, String lastName) {
        this.id= id;
        this.firstName =firstName;
        this.lastName  = lastName;
    }

    public String getAdressDto() {

        return ("City : "+ adressDto.getCity());
    }


}
