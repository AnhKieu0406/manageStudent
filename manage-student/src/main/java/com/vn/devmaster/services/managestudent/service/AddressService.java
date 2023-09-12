package com.vn.devmaster.services.managestudent.service;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.mapper.AddressMapper;
import com.vn.devmaster.services.managestudent.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private AddressMapper addressMapper;

    public List<Adress> getAll(){
        List<Adress> list = adressRepository.findAll();
        return list;
    }
}
