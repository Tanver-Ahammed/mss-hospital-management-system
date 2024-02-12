package com.mss.hms.services;

import com.mss.hms.dto.PrescriptionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrescriptionService {

    PrescriptionDTO addPrescription(PrescriptionDTO prescriptionDTO);

    List<PrescriptionDTO> getAllPrescriptions();

    PrescriptionDTO getSingleDepartmentById(Long prescriptionId);

    PrescriptionDTO updatePrescription(PrescriptionDTO prescriptionDTO, Long prescriptionId);

    boolean deletePrescription(Long prescriptionId);

}
