package com.vn.devmaster.services.managestudent.controller;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/studentss")
     List<StudentDTO> getStudentDTOS(){
        return  studentService.findAll();
    }

    @PostMapping("/student")
    String save(@RequestBody Student student){
        studentService.save(student);
        return "Oke";

    }
    @GetMapping("/findname")
    List<Student> findName(@RequestParam("firstName") String name){
        return studentService.getByName(name);
    }
}
