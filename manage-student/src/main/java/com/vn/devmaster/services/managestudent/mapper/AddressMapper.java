package com.vn.devmaster.services.managestudent.mapper;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.dto.AdressDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AddressMapper implements EntityMapper<Adress, AdressDto>{
    @Override
    public Adress toEntity(AdressDto dto) {
        Adress adress = Adress.builder()
                .id(dto.getId())
                .name(dto.getName())
                .city(dto.getCity())
                .district(dto.getDistrict())
                .build();
        return adress;
    }

    @Override
    public List<Adress> toEntity(List<AdressDto> d) {
        return null;
    }

    @Override
    public AdressDto toDto(Adress adress) {
        return AdressDto
                .builder()
                .id(adress.getId())
                .city(adress.getCity())
                .district(adress.getDistrict())
                .name(adress.getName())
                .build();
    }

    @Override
    public List<AdressDto> toDto(List<Adress> e) {
        List<AdressDto> adressDtos = new ArrayList<>();
        e.forEach(adress -> {
            adressDtos.add(toDto(adress));
        });
        return adressDtos;
    }


}
