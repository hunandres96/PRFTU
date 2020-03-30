//package com.hunandres.demopostgres.service.ServiceImpl;
//
//import com.hunandres.demopostgres.dto.DepartmentDTO;
//import com.hunandres.demopostgres.entity.Department;
//import com.hunandres.demopostgres.repositories.DepartmentRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.modelmapper.ModelMapper;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DepartmentServiceImplTest {
//
//    @Mock
//    private DepartmentRepository departmentRepository;
//
//    @Mock
//    ModelMapper modelMapper;
//
//    @InjectMocks
//    private DepartmentServiceImpl departmentService;
//
//    @Test
//    public void fintAllDepartmentsTest() {
//
//        List<Department> departments = new ArrayList<>();
//        departments.add(Department.builder()
//                .id(1)
//                .name("Marketing")
//                .build());
//        when(departmentRepository.findAll()).thenReturn(departments);
//
//        DepartmentDTO departmentDTO = DepartmentDTO.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//        when(modelMapper.map(any(), eq(DepartmentDTO.class))).thenReturn(departmentDTO);
//
//        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentRepository, modelMapper);
//        List<DepartmentDTO> departmentDTOS = departmentService.findAll();
//        assertNotNull(departmentDTOS);
//
//        verify(departmentRepository).findAll();
//        verify(modelMapper).map(any(), eq(DepartmentDTO.class));
//
//    }
//
//    @Test
//    public void findDepartmentById() {
//
//        Department department = Department.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//
//        DepartmentDTO departmentDTO = DepartmentDTO.builder()
//                .id(1)
//                .name("Marketing")
//                .build();
//
//        Optional<Department> optionalDepartment = Optional.of(department);
//        when(departmentRepository.findById(1)).thenReturn(optionalDepartment);
//        when(modelMapper.map(department, DepartmentDTO.class)).thenReturn(departmentDTO);
//
//        departmentService.findDepartmentById(1);
//
//        verify(departmentRepository).findById(1);
//        verify(modelMapper).map(department, DepartmentDTO.class);
//
//    }
//
//}
