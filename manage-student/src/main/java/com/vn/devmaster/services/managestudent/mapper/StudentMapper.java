package com.vn.devmaster.services.managestudent.mapper;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.domain.StudentSubject;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper  {


    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private StudentSubjectMapper studentSubjectMapper;


    public Student toEntity(StudentDTO dto) {
        Student student = Student.builder()
//                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
           //     .adress(addressMapper.toEntity(dto.getAdressDto()))
                .build();

        return student;
    }

    public List<Student> toEntity(List<StudentDTO> dtos) {
        List<Student> students = new ArrayList<>();
        dtos.forEach(dto -> {
            students.add(toEntity(dto));
        });
        return students;
    }

    public StudentDTO toDTO(Student entity) {
        StudentDTO student = StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getFirstName() + ' ' + entity.getLastName())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .adress(addressMapper.toDto(entity.getAdress()))
               .subjectDtos(subjectMapper.toDto(entity.getSubjects()))
                .studentSubjectDto(studentSubjectMapper.toDto(entity.getStudentSubjects()))
                .build();



        return student;
    }

    public List<StudentDTO> toDTO(List<Student> entities) {
        List<StudentDTO> students = new ArrayList<>();
        entities.forEach(entity -> {
            students.add(toDTO(entity));
        });
        return students;
    }






}
