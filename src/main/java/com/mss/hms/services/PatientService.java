package com.mss.hms.services;

import com.mss.hms.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    PatientDTO addPatient(PatientDTO patientDTO);

    List<PatientDTO> getAllPatients();

    PatientDTO getSinglePatientById(Long patientId);

    PatientDTO updatePatient(PatientDTO patientDTO, Long patientId);

    boolean deletePatient(Long patientId);

}
