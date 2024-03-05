package com.mss.hms.services;

import com.mss.hms.dto.PrescriptionDTO;
import com.mss.hms.entities.Prescription;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    private final ModelMapper modelMapper;

    public PrescriptionDTO addPrescription(PrescriptionDTO prescriptionDTO) {
        return null;
    }

    public List<PrescriptionDTO> getAllPrescriptions() {
        return null;
    }

    public PrescriptionDTO getSingleDepartmentById(Long prescriptionId) {
        return null;
    }

    public PrescriptionDTO updatePrescription(PrescriptionDTO prescriptionDTO, Long prescriptionId) {
        return null;
    }

    public boolean deletePrescription(Long prescriptionId) {
        return false;
    }

    protected Prescription getPrescriptionById(Long prescriptionId) {
        return this.prescriptionRepository.findById(prescriptionId).orElseThrow(() ->
                new ResourceNotFoundException("Patient", "Id", prescriptionId)
        );
    }

    protected PrescriptionDTO prescriptionToDTO(Prescription prescription) {
        return this.modelMapper.map(prescription, PrescriptionDTO.class);
    }

    protected Prescription dtoToPrescription(PrescriptionDTO prescriptionDTO) {
        return this.modelMapper.map(prescriptionDTO, Prescription.class);
    }

}
