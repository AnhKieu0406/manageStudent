package com.vn.devmaster.services.managestudent.projection;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.dto.AdressDto;
import org.springframework.beans.factory.annotation.Value;

public interface StudentProject {
    Integer getId();

    String getName();

    String getFirstName();

    String getCity();

    Integer getPoint();

    AdressDto getAddress();

    interface AdressDto{
        String getCity();
    }









}
