package com.vn.devmaster.services.managestudent.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vn.devmaster.services.managestudent.dto.StudentDTO;
import com.vn.devmaster.services.managestudent.dto.StudentDto1;
import com.vn.devmaster.services.managestudent.dto.StudentDto2;
import lombok.*;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SqlResultSetMapping(
        name = "/studentMapping",
        classes={
                @ConstructorResult(
                        targetClass = StudentDto1.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "fullName",type = String.class),
                                @ColumnResult(name = "first_name",type = String.class),
                                @ColumnResult(name = "last_name",type = String.class),
                                @ColumnResult(name = "city",type = String.class),
                        }
                )
        })
@SqlResultSetMapping(
        name = "/studentMapping1",
        classes={
                @ConstructorResult(
                        targetClass = StudentDto2.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "fullName", type = String.class),
                                @ColumnResult(name = "city", type = String.class),
                                @ColumnResult(name = "point", type = Integer.class),
                        }
                )
        }
        )
@NamedNativeQuery(
        name = "Student.GetAllStudent",
        query = "select  s.id, CONCAT(s.first_name,' ',s.last_name) as fullName ,  s.first_name,s.last_name, a.city " +
                " from student  s  RIGHT join adress  a " +
                "on s.id_address = a.id  " +
                "where a.city like concat( '%',:city,'%')  ",
        resultSetMapping = "/studentMapping",
        resultClass = StudentDto1.class
)
@NamedNativeQuery(
        name = "Student.GetAllStudentSuject",
        query = "select s.id, CONCAT(s.first_name,' ',s.last_name )as fullName  , a.city, ss.point " +
                "                 from student  s  RIGHT join adress a " +
                "                on s.id_address = a.id\n" +
                "                inner  join student_subject ss on ss.id_student = s.id ",
        resultSetMapping = "/studentMapping1",
        resultClass = StudentDto2.class
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
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

//
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    private List<Subject> subjects = new ArrayList<>();



  


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_class")
    @Fetch(FetchMode.JOIN)
    private Classed classed;








}
