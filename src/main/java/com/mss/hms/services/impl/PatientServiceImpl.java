package com.mss.hms.services.impl;

import com.mss.hms.dto.PatientDTO;
import com.mss.hms.entities.Patient;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.PatientRepository;
import com.mss.hms.services.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;

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

    protected Patient getPatientById(Long patientId) {
        return this.patientRepository.findById(patientId).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", patientId)
        );
    }

    protected PatientDTO patientToDTO(Patient patient) {
        return this.modelMapper.map(patient, PatientDTO.class);
    }

    protected Patient dtoToPatient(PatientDTO patientDTO) {
        return this.modelMapper.map(patientDTO, Patient.class);
    }
    
}
