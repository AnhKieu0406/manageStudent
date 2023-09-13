package com.vn.devmaster.services.managestudent.controller;

import com.vn.devmaster.services.managestudent.domain.Adress;
import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.service.AddressService;
import com.vn.devmaster.services.managestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    AddressService addressService;


    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }

//    @GetMapping("/address")
//    List<Adress> getAll1(){
//        return addressService.getAll();
//    }

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
        List<StudentDTO> dtos = studentService.filterByname(name);
        return  dtos;
    }

    @GetMapping("/findid")
    List<StudentDTO> findById(@RequestParam("id") Integer id){
        List<StudentDTO> dtos = studentService.findById(id);
        return dtos;
    }

    @GetMapping("/findByCity")
    List<StudentDTO> findByCity(@RequestParam("city")String city){
//        List<StudentDTO> dtos = studentService.findByCity(city);
        return studentService.findByCity(city);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){

        return studentService.deletebyId(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestParam("id")Integer id,@RequestBody Student student){
        return studentService.update(id,student);
    }



}
