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
    @GeneratedValue
    private Integer id;

    private String course_name;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Professor professor;
}
