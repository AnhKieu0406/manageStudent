package com.vn.devmaster.services.managestudent.dto;

import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

/**
 * DTO for {@link com.vn.devmaster.services.managestudent.domain.StudentSubject}
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class StudentSubjectDto  {
    private  int  point;

}