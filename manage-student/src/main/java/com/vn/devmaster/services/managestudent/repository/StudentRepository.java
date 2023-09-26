package com.vn.devmaster.services.managestudent.repository;


import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;

import com.vn.devmaster.services.managestudent.dto.StudentDto1;
import com.vn.devmaster.services.managestudent.dto.StudentDto2;
import com.vn.devmaster.services.managestudent.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.vn.devmaster.services.managestudent.untils.Sql.*;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //viết query theo native
//    @Query(nativeQuery = true, value = "SELECT * from student"+
//                                        " where first_name = :name")
//    List<Student> filterByName(@Param("name") String name);


    //HQL
    @Query(value = "select s from Student s where s.firstName like concat( '%',:name,'%') ")
    List<StudentDTO> filterByName(@Param("name") String name);


    @Query(value = "select s  from Student s where s.id = ?1 ")
    Student findAllById(@Param("id") Integer id);

    // Find Student By city
    //s.id, s.firstName,s.lastName , s.adress.city
//
//    @Query(nativeQuery = true, value = "SELECT  s  " +
//            "  from Student s  join  Adress  a on a.id = s.id_address " +
//            "where a.city like concat( '%',:name,'%') ;")
//    List<StudentDTO> findAllStudentByCity(@Param("city") String city);


    @Query(nativeQuery = true, value = "select  s.*  " +
            "from student s\n" +
            "inner  join  student_subject sj on sj.id_student = s.id " +
            "inner  join  subject sb on sb.id   = sj.id_subject  " +
            "where  sb.name like concat('%',:name,'%')")
    List<Student> findAllBySubjects(@Param("name") String name);

    @Query(nativeQuery = true, value = "select distinct s.*  from student  s "
            + " join student_subject b on b.id_student=s.id   "
            + "where b.point > 8 ; ")
    List<Student> findAllByPoint();


    @Query(nativeQuery = true, value = "select  s.* " +
            "from student  s " +
            "RIGHT join adress a on s.id_address = a.id " +
            "where a.city like concat('%',:city,'%') ")
    List<Student> findStudentByAdress_City(@Param("city") String city);


//    @Query(value = "SELECT   s.id,s.first_name,s.last_name from  student s",nativeQuery = true)
//    List<StudentProject> getStudent();

    @Query(nativeQuery = true)
    List<StudentDto1> GetAllStudent(@Param("city") String city);

    @Query(nativeQuery = true)
    List<StudentDto2> GetAllStudentSuject();

//    @Query(value = "select s.id, CONCAT(s.first_name,' ',s.last_name)  name ," +
//            "s.first_name firstName ," +
//            " a.city  city," +
//            " ss.point point " +
//            "from Student  s" +
//            " inner join adress a on a.id = s.id_address " +
//            "inner join student_subject ss on  ss.id_student =s.id ", nativeQuery = true)

    @Query(value = STUDENT_FILER_BY_CLASS, nativeQuery = true)
    List<StudentProject> getStudentProjection();

    @Query(value = STUDENT_AVG, nativeQuery = true)
    List<StudentAvg> getStudentAvg();

    @Query(value = SUBJECT_AVG,nativeQuery = true)
    List<SubjectAvg> getSubjectAvg();

    @Query(value = STUDENT_MAX_POINT,nativeQuery = true)
    List<StudentMaxPoint> getStudentMaxPoint();

    @Query(value = STUDENT_HOCBONG,nativeQuery = true)
    List<StudentHocBong> getStudentHocBong();

    @Query(value = STUDENT_POINT_MIN,nativeQuery = true)
    List<StudentMinPoint> getStudentMinPoint();
}
