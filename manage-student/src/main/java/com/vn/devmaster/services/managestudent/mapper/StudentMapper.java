package com.vn.devmaster.services.managestudent.mapper;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    public StudentDTO toDTO(Student entity){
        StudentDTO dto = StudentDTO.builder()
                .id(entity.getId())
                .name(entity.getLastName()+" "+ entity.getFirstName())
                .build();
        return dto;
    }

    public List<StudentDTO> toDTO(List<Student> entities){
        List<StudentDTO> dtos = new ArrayList<>();
        entities.forEach(student -> {
            StudentDTO dto = toDTO(student);
            dtos.add(dto);
        });
        return dtos;
    }

    public Student toEntity(Student dto){
        Student student = Student.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

        return student;
    }
}
