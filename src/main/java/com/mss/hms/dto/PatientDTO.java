package com.mss.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
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

    private String role;

    private String verificationCode;

    private String address;

    private List<AttachmentDTO> attachments = new ArrayList<>();

    private List<PrescriptionDTO> prescriptions = new ArrayList<>();

    private List<TestPatientHistoryDTO> testPatientHistories = new ArrayList<>();

}
