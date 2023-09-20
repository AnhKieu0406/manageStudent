package com.vn.devmaster.services.managestudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.vn.devmaster.services.managestudent.domain.Subject}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SubjectDto {
    Integer id;
    String name;
}