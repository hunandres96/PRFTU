package com.hunandres.demopostgres.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    private Major major;

}
