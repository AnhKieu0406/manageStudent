package com.vn.devmaster.services.managestudent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name ="student")
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Integer id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    @Fetch(FetchMode.JOIN)
    private Adress adress ;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private List<Subject> subjects = new ArrayList<>();



}
