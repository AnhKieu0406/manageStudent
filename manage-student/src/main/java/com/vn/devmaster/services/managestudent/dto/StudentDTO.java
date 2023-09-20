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
@ToString
public class StudentDTO   {

    private Integer id;
    private String name;
    private String firstName;
    private String lastName;
    private String city;
    private AdressDto adress;
    private List<SubjectDto> subjectDtos;
   private List<StudentSubjectDto> studentSubjectDto;

    public StudentDTO(Integer id, String name,String firstName, String city) {
        this.id= id;
        this.name =firstName +lastName;
        this.firstName = firstName;
        this.city = adress.getCity();


    }



    public String getAdressDto() {

        return ("City : "+ adress.getCity());
    }


}
