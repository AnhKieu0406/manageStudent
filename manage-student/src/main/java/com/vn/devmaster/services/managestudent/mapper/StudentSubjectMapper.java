package com.vn.devmaster.services.managestudent.mapper;

import com.vn.devmaster.services.managestudent.domain.Student;
import com.vn.devmaster.services.managestudent.domain.StudentSubject;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.dto.StudentSubjectDto;
import com.vn.devmaster.services.managestudent.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentSubjectMapper implements EntityMapper<StudentSubject,StudentSubjectDto>{



    @Override
    public StudentSubject toEntity(StudentSubjectDto dto) {
        StudentSubject subject = StudentSubject.builder()
                .point(dto.getPoint())
                .build();
        return null;
    }

    @Override
    public List<StudentSubject> toEntity(List<StudentSubjectDto> d) {
        List<StudentSubject> list = new ArrayList<>();
        d.forEach(dto -> {
            list.add(toEntity(dto));
        });
        return null;
    }

    @Override
    public StudentSubjectDto toDto(StudentSubject entity) {
        StudentSubjectDto dto = StudentSubjectDto.builder()
                .point(entity.getPoint())
                .build();

        return dto;
    }

    @Override
    public List<StudentSubjectDto> toDto(List<StudentSubject> e) {
        List<StudentSubjectDto> dtos = new ArrayList<>();
        e.forEach(studentSubject -> dtos.add(toDto(studentSubject)));
        return dtos;
    }
}
