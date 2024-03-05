package com.mss.hms.services;

import com.mss.hms.dto.MedicineDTO;
import com.mss.hms.entities.Medicine;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineService {

    private MedicineRepository medicineRepository;

    private final ModelMapper modelMapper;

    public MedicineDTO addMedicine(MedicineDTO medicineDTO) {
        return null;
    }

    public List<MedicineDTO> getAllMedicines() {
        return null;
    }

    public MedicineDTO getSingleMedicineById(Long departmentId) {
        return null;
    }

    public MedicineDTO updateMedicine(MedicineDTO MedicineDTO, Long medicineId) {
        return null;
    }

    public boolean deleteMedicine(Long medicineId) {
        return false;
    }

    protected Medicine getMedicineById(Long medicineId) {
        return this.medicineRepository.findById(medicineId).orElseThrow(() ->
                new ResourceNotFoundException("Medicine", "Id", medicineId)
        );
    }

    protected MedicineDTO medicineToDTO(Medicine medicine) {
        return this.modelMapper.map(medicine, MedicineDTO.class);
    }

    protected Medicine dtoToMedicine(MedicineDTO medicineDTO) {
        return this.modelMapper.map(medicineDTO, Medicine.class);
    }

}
