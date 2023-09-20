package com.vn.devmaster.services.managestudent.repository;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.projection.AddressProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

    @Query(value = "SELECT a.id, a.name , a.city, a.district from  Adress a  ")
    List<AddressProject> getAll();
}