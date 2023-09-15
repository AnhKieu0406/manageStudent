package com.vn.devmaster.services.managestudent.repository;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.dto.AdressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
//    @Query(value = "SELECT new com.vn.devmaster.services.managestudent.dto.AdressDto(s.id, s.firstName, a.city) "
//            +"  from Student s inner JOIN s.adress a ")
//    List<AdressDto> finndByAdress();

}