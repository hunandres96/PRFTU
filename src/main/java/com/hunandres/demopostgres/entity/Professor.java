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
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "professor_name")
    private String professor_name;

    @Column(name = "professor_email")
    private String professor_email;

    @ManyToOne
    private Department department;

}