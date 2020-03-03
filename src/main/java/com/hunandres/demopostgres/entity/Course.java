package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    private String id;

    private String course_name;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Professor professor;
}
