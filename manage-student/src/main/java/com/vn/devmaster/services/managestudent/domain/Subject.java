package com.vn.devmaster.services.managestudent.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 250)
    private String name;

//    @ManyToMany(mappedBy = "subjects")
//    List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
    private List<StudentSubject>  studentSubjects;
}