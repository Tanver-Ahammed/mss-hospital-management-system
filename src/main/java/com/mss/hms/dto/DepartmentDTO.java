package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "department's name must be min of 3 to 100 character")
    private String name;

    private List<DoctorDTO> doctorDTOs = new ArrayList<>();

}
