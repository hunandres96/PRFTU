package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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

    //@OneToOne(mappedBy = "department")
    //@OneToMany
    //@JoinColumn(name = "department")
    //private List<Course> courses;

}
