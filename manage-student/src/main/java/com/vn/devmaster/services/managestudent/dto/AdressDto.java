package com.vn.devmaster.services.managestudent.dto;

import com.vn.devmaster.services.managestudent.domain.Adress;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.vn.devmaster.services.managestudent.domain.Adress}
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdressDto  {
    Integer id;
    String name;
    String city;
    String district;


    /**
     * DTO for {@link com.vn.devmaster.services.managestudent.domain.Student}
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentDto implements Serializable {
        private Integer id;
        private String firstName;
        private String lastName;
    }
}