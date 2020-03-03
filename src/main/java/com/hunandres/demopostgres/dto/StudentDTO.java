package com.hunandres.demopostgres.dto;

import com.hunandres.demopostgres.entity.Course;
import com.hunandres.demopostgres.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    private String student_name;
    private String student_email;
    private Major major;

}
