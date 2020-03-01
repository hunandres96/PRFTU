package com.hunandres.demopostgres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchRequest {

    private String[] courseId;
    private Integer[] majorId;

}
