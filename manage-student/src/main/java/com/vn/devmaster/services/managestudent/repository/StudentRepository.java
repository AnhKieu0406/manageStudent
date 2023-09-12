package com.vn.devmaster.services.managestudent.repository;


import com.vn.devmaster.services.managestudent.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface  StudentRepository extends JpaRepository<Student,Integer> {

    //viết query theo native
//    @Query(nativeQuery = true, value = "SELECT * from student"+
//                                        " where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);


    //HQL
    @Query(value = "select s from Student s where s.firstName like concat( '%',:name,'%') ")
    List<Student> filterByName(@Param("name") String name);

    List<Student> findAllByFirstName(String name);

    @Query(value = "select s  from Student s where s.id = ?1 ")
   List<Student> findAllById(@Param("id") Integer id);



    @Query(value = "select s from Student s"+
            " RIGHT join Adress a on s.adress.id =a.id "+
            "where a.city like concat('%',:city,'%') ")
    List<Student> findAllByAdress_City(@Param("city") String city);

     void deleteById(Integer id);
}
