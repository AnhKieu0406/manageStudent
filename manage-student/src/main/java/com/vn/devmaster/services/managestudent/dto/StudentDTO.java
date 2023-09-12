package com.vn.devmaster.services.managestudent.dto;

import com.vn.devmaster.services.managestudent.domain.Adress;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
public class StudentDTO {
    private Integer id;
    private String name;
    private String firstName;
    private String lastName;
    private AdressDto adressDto;


}
