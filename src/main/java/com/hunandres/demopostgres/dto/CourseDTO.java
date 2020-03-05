package com.hunandres.demopostgres.dto;

import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.entity.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer id;
    private String course_name;
    private Department department;
    private Professor professor;

}
