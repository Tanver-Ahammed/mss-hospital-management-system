package com.mss.hms.services.impl;


import com.mss.hms.dto.PatientDTO;
import com.mss.hms.repository.PatientRepository;
import com.mss.hms.services.PatientService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public List<PatientDTO> getAllPatients() {
        return null;
    }

    @Override
    public PatientDTO getSinglePatientById(Long patientId) {
        return null;
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO, Long patientId) {
        return null;
    }

    @Override
    public boolean deletePatient(Long patientId) {
        return false;
    }
}
