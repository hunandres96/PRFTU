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
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue
    private int id;

    private String professor_name;

    private String professor_email;

}