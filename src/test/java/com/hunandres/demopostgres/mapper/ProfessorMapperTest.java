package com.hunandres.demopostgres.mapper;

import com.hunandres.demopostgres.dto.ProfessorDTO;
import com.hunandres.demopostgres.entity.Department;
import com.hunandres.demopostgres.entity.Professor;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.is;

public class ProfessorMapperTest {

    private ProfessorMapper professorMapper = new ProfessorMapper(new ModelMapper());

    @Test
    public void professor_to_professorDTO() {

        Professor professor = new Professor();
        professor.setId(1);
        professor.setProfessor_name("John Doe");
        professor.setProfessor_email("johndoe@gmail.com");
        professor.setDepartment(Department.builder().id(1).department_name("Marketing").build());

        ProfessorDTO professorDTO = professorMapper.transform(professor);

        assertEquals(professor.getProfessor_name(), professorDTO.getProfessor_name());
        assertEquals(professor.getProfessor_email(), professorDTO.getProfessor_email());
        assertEquals(professor.getDepartment(), professorDTO.getDepartment());

    }

    @Test
    public void professorDTO_to_professor() {

        ProfessorDTO professorDTO = new ProfessorDTO();
        professorDTO.setId(1);
        professorDTO.setProfessor_name("John Doe");
        professorDTO.setProfessor_email("johndoe@gmail.com");
        professorDTO.setDepartment(Department.builder().id(1).department_name("Marketing").build());

        Professor professor = professorMapper.reverseTransform(professorDTO);

        assertEquals(professorDTO.getProfessor_name(), professor.getProfessor_name());
        assertEquals(professorDTO.getProfessor_email(), professor.getProfessor_email());

    }


}
