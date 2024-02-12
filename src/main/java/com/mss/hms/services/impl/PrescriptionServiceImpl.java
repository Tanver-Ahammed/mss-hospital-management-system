package com.mss.hms.services.impl;

import com.mss.hms.dto.PrescriptionDTO;
import com.mss.hms.repository.PrescriptionRepository;
import com.mss.hms.services.PrescriptionService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private PrescriptionRepository prescriptionRepository;

    @Override
    public PrescriptionDTO addPrescription(PrescriptionDTO prescriptionDTO) {
        return null;
    }

    @Override
    public List<PrescriptionDTO> getAllPrescriptions() {
        return null;
    }

    @Override
    public PrescriptionDTO getSingleDepartmentById(Long prescriptionId) {
        return null;
    }

    @Override
    public PrescriptionDTO updatePrescription(PrescriptionDTO prescriptionDTO, Long prescriptionId) {
        return null;
    }

    @Override
    public boolean deletePrescription(Long prescriptionId) {
        return false;
    }
}
