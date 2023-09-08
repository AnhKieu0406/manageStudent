package com.vn.devmaster.services.managestudent.repository;


import com.vn.devmaster.services.managestudent.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  StudentRepository extends JpaRepository<Student,Integer> {

}
