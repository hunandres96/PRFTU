package com.hunandres.demopostgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "courseSeq")
    @SequenceGenerator(name = "courseSeq", sequenceName = "course_seq", initialValue = 41, allocationSize = 1)
    private Integer id;

    @Column(name = "course_name")
    private String name;

    //@JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    //@JoinColumn(name = "professor_id")
    @ManyToOne
    private Professor professor;

//    @OneToOne
//    @JoinColumn(name = "department_id")
//    private Department department;
//
//    @OneToOne
//    @JoinColumn(name = "professor_id")
//    private Professor professor;

}
