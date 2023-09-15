package com.vn.devmaster.services.managestudent.repository;


import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  StudentRepository extends JpaRepository<Student,Integer> {

    //viết query theo native
//    @Query(nativeQuery = true, value = "SELECT * from student"+
//                                        " where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);


    //HQL
    @Query(value = "select s from Student s where s.firstName like concat( '%',:name,'%') ")
    List<Student> filterByName(@Param("name") String name);



    @Query(value = "select s  from Student s where s.id = ?1 ")
   Student findAllById(@Param("id") Integer id);




    @Query(nativeQuery = true,  value = "select  s.id, first_name, last_name, id_address,a.city   " +
            "from Student  s "+
            "RIGHT join Adress a on s.id_address = a.id   " +
            "where a.city like concat('%',:city,'%') " )
    List<Student> findStudentByAdress_City(@Param("city") String city);



    @Query(nativeQuery = true, value = "select  s.*  " +
            "from student s\n" +
            "inner  join  student_subject sj on sj.id_student = s.id " +
            "inner  join  subject sb on sb.id   = sj.id_subject  " +
            "where  sb.name like concat('%',:name,'%')")
    List<Student> findAllBySubjects(@Param("name")String name );

    @Query(nativeQuery = true, value = "select  s.*  from student  s "
            + " join student_subject b on b.id_student=s.id   "
            +"where b.point > 8 ; " )
      List<Student> findAllByPoint() ;



//     Student updateAllById(Integer id);
}
