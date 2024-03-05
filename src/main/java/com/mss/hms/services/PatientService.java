package com.mss.hms.services;

import com.mss.hms.dto.PatientDTO;
import com.mss.hms.entities.Patient;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    private final ModelMapper modelMapper;

    public PatientDTO addPatient(PatientDTO patientDTO) {
        return null;
    }

    public List<PatientDTO> getAllPatients() {
        return null;
    }

    public PatientDTO getSinglePatientById(Long patientId) {
        return null;
    }

    public PatientDTO updatePatient(PatientDTO patientDTO, Long patientId) {
        return null;
    }

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
