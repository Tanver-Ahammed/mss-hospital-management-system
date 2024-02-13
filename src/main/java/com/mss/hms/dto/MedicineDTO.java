package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "medicine name can't be empty!!")
    @Size(min = 3, max = 100, message = "medicine's name must be min of 3 to 100 character")
    private String name;

    private String companyName;

    private String description;

    private PrescriptionDTO prescription;

}
