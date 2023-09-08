package com.vn.devmaster.services.managestudent.service;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.mapper.StudentMapper;
import com.vn.devmaster.services.managestudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Autowired
//    private StudentMapper studentMapper;
//    @Override
//    public List<Student> findAll() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public List<StudentDTO> findAllDTO() {
//        List<Student> list = findAll();
//        return studentMapper.toDTO(list);
//    }
//
//    @Override
//    public StudentDTO findById(Integer id) {
//        Student  list = (Student) findAll();
//        return studentMapper.toDTO(list).getId();
//    }
}
