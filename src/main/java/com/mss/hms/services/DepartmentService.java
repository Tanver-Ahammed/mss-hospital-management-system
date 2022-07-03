package com.mss.hms.services;

import com.mss.hms.dto.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartment();

    DepartmentDTO getSingleDepartmentById(Long departmentId);

    DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long departmentId);

}
