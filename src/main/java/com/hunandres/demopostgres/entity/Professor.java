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
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue
    private int id;

    private String professor_name;

    private String professor_email;

    @ManyToOne
    private Department department;

}