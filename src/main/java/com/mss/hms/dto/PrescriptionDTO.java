package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "prescription date can't be empty!!")
    private Date date;

//    @NotEmpty(message = "prescription serial no can't be empty!!")
    private Integer serialNo;

    @NotEmpty(message = "prescription price can't be empty!!")
    private Double price;

    @NotEmpty(message = "prescription date can't be empty!!")
    private int discount;

//    @NotEmpty
    private Boolean isApproveByDoctor;

    private UserDTO doctor;

    private PatientDTO patient;

    private List<MedicineDTO> medicines;

}
