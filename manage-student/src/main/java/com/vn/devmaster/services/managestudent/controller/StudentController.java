package com.vn.devmaster.services.managestudent.controller;


import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;

import com.vn.devmaster.services.managestudent.dto.StudentDto1;
import com.vn.devmaster.services.managestudent.dto.StudentDto2;
import com.vn.devmaster.services.managestudent.projection.StudentProject;
import com.vn.devmaster.services.managestudent.repository.StudentRepository;
import com.vn.devmaster.services.managestudent.service.AddressService;
import com.vn.devmaster.services.managestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    AddressService addressService;


    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }



    @GetMapping("/studentss")
     List<StudentDTO> getStudentDTOS(){
        return  studentService.findAll();
    }

    @PostMapping("/student")
    String save(@RequestBody StudentDTO student){
        studentService.save(student);
        return "Oke";

    }
    @GetMapping("/findname")
    List<Student> findName(@RequestParam("firstName") String name){
        return studentService.getByName(name);
    }

    @PostMapping("/students")
    String save(@RequestBody List<StudentDTO> studentDTOS){
        studentService.save(studentDTOS);
        return "oke";
    }
    @GetMapping("/filter-name")
    List<StudentDTO> filterByName(@RequestParam("name") String name){
        List<StudentDTO> dtos = studentService.filterByName(name);
        return  dtos;
    }

    @GetMapping("/findid")
    StudentDTO findById(@RequestParam("id") Integer id){
        return studentService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){

        return studentService.deletebyId(id);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestParam("id")Integer id,@RequestBody Student student){
        studentService.update(id,student);
        return "Update Suscess";
    }

    @GetMapping("/findAllStudentBySubject")
    List<StudentDTO> findBySubjectName(@RequestParam("name") String name){
        return studentService.findBySubject(name);
    }

    @GetMapping("/findAllByPoint")
    List<StudentDTO> findByPoint(){
        return studentService.findByPoint();
    }

    @GetMapping("/findByCity")
        public List<StudentDTO> findByCity(@RequestParam("city")String city){
        return studentService.findByCity(city);
    }

    @GetMapping("/getStudentDTO1")
    public ResponseEntity<List<StudentDto1>> GetAllStudent(String city){
        return ResponseEntity.ok(studentRepository.GetAllStudent(city));
    }

    @GetMapping("/getStudentDTO2")
    public ResponseEntity<List<StudentDto2>> GetAllStudent1(){
        return ResponseEntity.ok(studentRepository.GetAllStudentSuject());
    }


    @GetMapping("/findByCityProjection")
    public List<StudentProject> findByCityProjection(){
        return studentService.findStudentAttributr();
    }



}
