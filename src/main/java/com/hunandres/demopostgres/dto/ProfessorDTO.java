package com.hunandres.demopostgres.dto;

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
    private String professor_name;
    private String professor_email;

}
