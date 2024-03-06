package com.mss.hms.services;

import com.mss.hms.dto.RoleDTO;
import com.mss.hms.entities.Role;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    private ModelMapper modelMapper;

    public List<RoleDTO> getAllRoles() {
        return this.roleRepository
                .findAll()
                .stream()
                .map(role -> modelMapper.map(role, RoleDTO.class))
                .toList();
    }

    public RoleDTO getSingleRoleById(Long roleId) {
        return this.modelMapper.map(this.getRoleById(roleId), RoleDTO.class);
    }

    public Role getRoleById(Long roleId) {
        return this.roleRepository.findById(roleId).orElseThrow(() ->
                new ResourceNotFoundException("Role", "Id", roleId));
    }

}
