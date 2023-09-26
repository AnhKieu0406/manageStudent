package com.vn.devmaster.services.managestudent.projection;

import javax.persistence.criteria.CriteriaBuilder;

public interface SubjectAvg {
    Integer getId();

    String getName();

    Double getAvg();
}
