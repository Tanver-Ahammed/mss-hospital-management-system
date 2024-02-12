package com.mss.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicineDTO {

    private Long id;

    private String name;

    private String companyName;

    private String description;

    private PrescriptionDTO prescription;

}
