package com.mss.hms.services;

import com.mss.hms.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    DistrictDTO addDistrict(DistrictDTO districtDTO);

    List<DistrictDTO> getAllDistrict();

}
