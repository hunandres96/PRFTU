package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_email")
    private String student_email;

    @ManyToOne
    private Major major;

}
