package com.mss.hms.services.impl;

import com.mss.hms.dto.DistrictDTO;
import com.mss.hms.entities.District;
import com.mss.hms.repository.DistrictRepository;
import com.mss.hms.services.DistrictService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DistrictDTO addDistrict(DistrictDTO districtDTO) {
        return this.modelMapper.map(this.districtRepository
                        .save(this.modelMapper.map(districtDTO, District.class)),
                DistrictDTO.class);
    }

    @Override
    public List<DistrictDTO> getAllDistrict() {
        return this.districtRepository
                .findAll()
                .stream()
                .map(district -> this.modelMapper.map(district, DistrictDTO.class))
                .collect(Collectors.toList());
    }

}
