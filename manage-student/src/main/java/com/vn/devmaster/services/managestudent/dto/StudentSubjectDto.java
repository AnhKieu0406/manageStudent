package com.vn.devmaster.services.managestudent.dto;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.vn.devmaster.services.managestudent.domain.StudentSubject}
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentSubjectDto  {
    private  int  point;

}