package com.hunandres.demopostgres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorSearchRequest {

    private Integer pageNo = 0;
    private Integer pageSize = 10;
    private String sortBy = "id";
    private String sortDir = "ASC";
    private Integer departmentId;

}
