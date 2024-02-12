package com.mss.hms.services.impl;

import com.mss.hms.dto.MedicineDTO;
import com.mss.hms.repository.MedicineRepository;
import com.mss.hms.services.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;

    @Override
    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {
        return null;
    }

    @Override
    public List<MedicineDTO> getAllMedicines() {
        return null;
    }

    @Override
    public MedicineDTO getSingleMedicineById(Long departmentId) {
        return null;
    }

    @Override
    public MedicineDTO updateMedicine(MedicineDTO MedicineDTO, Long medicineId) {
        return null;
    }

    @Override
    public boolean deleteMedicine(Long medicineId) {
        return false;
    }
}
