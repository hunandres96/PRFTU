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
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;

    private String student_name;

    private String student_email;
}
