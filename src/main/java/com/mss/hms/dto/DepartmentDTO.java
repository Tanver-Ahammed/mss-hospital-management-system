package com.mss.hms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

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

// @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")