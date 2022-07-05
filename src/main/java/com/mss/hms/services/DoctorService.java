package com.mss.hms.services;

import com.mss.hms.dto.DoctorDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface DoctorService {

    DoctorDTO registrationDoctor(DoctorDTO doctorDTO, MultipartFile doctorImage) throws IOException;

    List<DoctorDTO> getAllDoctor();

    DoctorDTO getSingleDoctorById(Long doctorId);

    DoctorDTO updateDoctor(DoctorDTO doctorDTO, Long doctorId, MultipartFile doctorImage);

}
