package com.mss.hms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class DoctorDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's name must be min of 3 to 100 character")
    private String nameEnglish;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's name must be min of 3 to 100 character")
    private String nameBengali;

    private String contact;

    @NotBlank
    private String email;

    private DepartmentDTO departmentDTO;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's degree must be min of 3 to 100 character")
    private String degreeEnglish;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's degree must be min of 3 to 100 character")
    private String degreeBengali;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's title must be min of 3 to 100 character")
    private String titleEnglish;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's title must be min of 3 to 100 character")
    private String titleBengali;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's institution must be min of 3 to 100 character")
    private String institutionEnglish;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor's institution must be min of 3 to 100 character")
    private String institutionBengali;

    private int age;

    private String bloodGroup;

    @Min(value = 300, message = "minimum doctor price 300 tk.")
    @Max(value = 1000, message = "maximum doctor price 1000 tk.")
    private Integer price;

    private String role;

    private String verificationCode;

    private boolean isActive;

    private String address;

    @NotBlank
    @Size(min = 5, max = 25, message = "doctor's password must be min of 5 to 25 character")
    private String password;

    private List<AttachmentDTO> attachmentDTOS = new ArrayList<>();

    private List<DoctorPatientDTO> doctorPatientDTOS = new ArrayList<>();

}
