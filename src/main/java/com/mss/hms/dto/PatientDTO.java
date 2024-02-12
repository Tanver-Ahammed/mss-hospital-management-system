package com.mss.hms.dto;

import com.mss.hms.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {

    private Long id;

    private String name;

    private String contact;

    private String email;

    private Short age;

    private String bloodGroup;

    private Short weight;

    private Date date;

    private String verificationCode;

    private List<Role> roles;

    private String address;

    private List<AttachmentDTO> attachments;

    private List<PrescriptionDTO> prescriptions;

    private List<TestPatientHistoryDTO> testPatientHistories;

}
