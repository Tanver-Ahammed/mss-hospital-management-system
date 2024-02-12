package com.mss.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PrescriptionDTO {

    private Long id;

    private Date date;

    private Short serialNo;

    private Double price;

    private int discount;

    private Boolean isApproveByDoctor;

    private UserDTO doctor;

    private PatientDTO patient;

    private List<MedicineDTO> medicines;

}
