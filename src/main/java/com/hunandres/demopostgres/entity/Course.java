package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private int id;

    private String course_name;
}
