package com.mss.hms.services.impl;

import com.mss.hms.config.AppConstants;
import com.mss.hms.dto.DoctorDTO;
import com.mss.hms.email.EmailSenderService;
import com.mss.hms.entities.Attachment;
import com.mss.hms.entities.Doctor;
import com.mss.hms.repository.AttachmentRepository;
import com.mss.hms.repository.DoctorRepository;
import com.mss.hms.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AttachmentServiceImpl attachmentService;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    @Override
    public DoctorDTO registrationDoctor(DoctorDTO doctorDTO, MultipartFile doctorImage) throws IOException {
        if (Objects.equals(doctorImage.getOriginalFilename(), "")) {
            return null;
        }

        Attachment attachment = this.modelMapper.map(this.attachmentService.addAttachment(doctorImage), Attachment.class);
        attachment.setAttachmentName("Image");

        doctorDTO.setActive(false);
        String verificationCode = RandomString.make(64);
        doctorDTO.setVerificationCode(verificationCode);

        Doctor doctor = this.modelMapper.map(doctorDTO, Doctor.class);

        doctor.setAttachment(attachment);

        doctor = this.doctorRepository.save(doctor);

        String siteURL = AppConstants.host + "/doctor/verify";
//        sendVerificationEmail(authorityDTO, siteURL);

        return this.modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> getAllDoctor() {
        return null;
    }

    @Override
    public DoctorDTO getSingleDoctorById(Long doctorId) {
        return null;
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO, Long doctorId, MultipartFile doctorImage) {
        return null;
    }
}
