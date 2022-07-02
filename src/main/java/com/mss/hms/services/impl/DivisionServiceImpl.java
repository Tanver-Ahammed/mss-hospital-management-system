package com.mss.hms.services.impl;

import com.mss.hms.dto.DivisionDTO;
import com.mss.hms.entities.Division;
import com.mss.hms.repository.DivisionRepository;
import com.mss.hms.services.DivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DivisionDTO addDivision(DivisionDTO divisionDTO) {
        return this.modelMapper
                .map(this.divisionRepository
                                .save(this.modelMapper
                                        .map(divisionDTO, Division.class)),
                        DivisionDTO.class);
    }

    @Override
    public List<DivisionDTO> getAllDivision() {
        return this.divisionRepository
                .findAll()
                .stream()
                .map(division -> this.modelMapper.map(division, DivisionDTO.class))
                .collect(Collectors.toList());
    }

}
