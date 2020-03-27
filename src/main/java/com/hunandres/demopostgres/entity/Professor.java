package com.hunandres.demopostgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "professorSeq")
    @SequenceGenerator(name = "professorSeq", sequenceName = "professor_seq", initialValue = 31, allocationSize = 1)
    private int id;

    @Column(name = "professor_name")
    private String name;

    @Column(name = "professor_email")
    private String email;

    @ManyToOne
    private Department department;

}