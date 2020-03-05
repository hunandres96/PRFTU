package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String student_name;

    private String student_email;

    @ManyToOne
    private Major major;

}
