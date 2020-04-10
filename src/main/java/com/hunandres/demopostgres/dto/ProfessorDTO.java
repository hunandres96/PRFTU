package com.hunandres.demopostgres.dto;

import com.hunandres.demopostgres.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Integer id;
    private String name;
    private String title;
    private String office;
    private String number;
    private String email;
    private Department department;

}
