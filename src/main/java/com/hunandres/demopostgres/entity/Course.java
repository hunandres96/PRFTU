package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;

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

    @Column(name = "course_number")
    private String number;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_description")
    private String description;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Professor professor;

}
