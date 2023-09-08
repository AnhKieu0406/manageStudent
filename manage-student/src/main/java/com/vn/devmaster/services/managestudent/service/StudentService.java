package com.vn.devmaster.services.managestudent.service;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.mapper.StudentMapper;
import com.vn.devmaster.services.managestudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class
StudentService {
//        List<Student> findAll();
//
//        List<StudentDTO> findAllDTO();
//
//        StudentDTO findById(Integer id);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;
    public List<Student> getAll(){
        List<Student> list = studentRepository.findAll();
        return list;
    }

    public List<StudentDTO> findAll(){
        List<Student> list = getAll();
       return studentMapper.toDTO(list);

    }

    public List<Student> getByName(String name){
        List<Student> list = getAll();
        List<Student>   findName = new ArrayList<>();
        for (Student student : list){
            if(student.getFirstName().equals(name)){
                findName.add(student);
            }
        }
        return findName;
    }

    public void save(Student student) {
        Student students = studentMapper.toEntity(student);
        studentRepository.save(student);
    }



}
