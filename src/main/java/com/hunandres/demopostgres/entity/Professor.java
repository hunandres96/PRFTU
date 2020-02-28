package com.hunandres.demopostgres.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
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