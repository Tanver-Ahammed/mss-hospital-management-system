package com.mss.hms.services;

import com.mss.hms.dto.DivisionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DivisionService {

    DivisionDTO addDivision(DivisionDTO divisionDTO);

    List<DivisionDTO> getAllDivision();

}
