package com.mss.hms.services;

import com.mss.hms.dto.DepartmentDTO;
import com.mss.hms.entities.Department;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        return this.modelMapper
                .map(this.departmentRepository
                                .save(this.modelMapper
                                        .map(departmentDTO, Department.class)),
                        DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartment() {
        return this.departmentRepository
                .findAll()
                .stream()
                .map(department -> this.modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO getSingleDepartmentById(Long departmentId) {
        return this.modelMapper.map(this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId)), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long departmentId) {
        Department department = this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", departmentId));
        department.setName(departmentDTO.getName());
        return this.modelMapper.map(this.departmentRepository.save(department), DepartmentDTO.class);
    }

    protected Department getDepartmentById(Long departmentId) {
        return this.departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", departmentId)
        );
    }

    protected DepartmentDTO patientToDTO(Department department) {
        return this.modelMapper.map(department, DepartmentDTO.class);
    }

    protected Department dtoToDepartment(DepartmentDTO departmentDTO) {
        return this.modelMapper.map(departmentDTO, Department.class);
    }

}
