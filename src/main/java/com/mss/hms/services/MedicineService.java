package com.mss.hms.services;

import com.mss.hms.dto.MedicineDTO;

import java.util.List;

public interface MedicineService {

    MedicineDTO addMedicine(MedicineDTO medicineDTO);

    List<MedicineDTO> getAllMedicines();

    MedicineDTO getSingleMedicineById(Long medicineId);

    MedicineDTO updateMedicine(MedicineDTO MedicineDTO, Long medicineId);

    boolean deleteMedicine(Long medicineId);

}
