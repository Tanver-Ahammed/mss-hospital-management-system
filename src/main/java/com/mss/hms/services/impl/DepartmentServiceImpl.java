package com.mss.hms.services.impl;

import com.mss.hms.dto.DepartmentDTO;
import com.mss.hms.entities.Department;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.DepartmentRepository;
import com.mss.hms.services.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        return this.modelMapper
                .map(this.departmentRepository
                                .save(this.modelMapper
                                        .map(departmentDTO, Department.class)),
                        DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        return this.departmentRepository
                .findAll()
                .stream()
                .map(department -> this.modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getSingleDepartmentById(Long departmentId) {
        return this.modelMapper.map(this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId)), DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long departmentId) {
        Department department = this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        department.setName(departmentDTO.getName());
        return this.modelMapper.map(this.departmentRepository.save(department), DepartmentDTO.class);
    }
}
