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
    private Integer id;
    private String name;
    private String city;
    private String district;

}