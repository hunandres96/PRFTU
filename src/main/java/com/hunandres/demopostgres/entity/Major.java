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
@Table(name = "major")
public class Major {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "major_name")
    private String major_name;
}
