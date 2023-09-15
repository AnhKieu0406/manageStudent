package com.vn.devmaster.services.managestudent.mapper;

import com.vn.devmaster.services.managestudent.domain.Subject;
import com.vn.devmaster.services.managestudent.dto.SubjectDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper implements EntityMapper<Subject, SubjectDto> {
    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDto> d) {
        return null;
    }

    @Override
    public SubjectDto toDto(Subject subject) {
        SubjectDto dto = new SubjectDto();
        dto.setName(subject.getName());
        return dto;
    }

    @Override
    public List<SubjectDto> toDto(List<Subject> e) {
        List<SubjectDto> dtos = new ArrayList<>();
        e.forEach(subject -> dtos.add(toDto(subject)));
        return dtos;
    }
}
