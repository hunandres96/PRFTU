package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "department_name")
    private String name;

//    @OneToMany
//    private List<Course> courses;
//
//    @OneToMany
//    private  List<Professor> professors;

}
