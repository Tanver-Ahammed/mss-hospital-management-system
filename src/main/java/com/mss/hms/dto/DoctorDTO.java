package com.mss.hms.dto;

import com.mss.hms.entities.Department;
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

    private Department department;

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

    @NotBlank
    private String price;

    @NotBlank
    @Size(min = 5, max = 25, message = "doctor's password must be min of 8 to 25 character")
    private String password;

    private String role;

    private String verificationCode;

    private boolean isActive;

    private List<DoctorPatientDTO> doctorPatientDTOS = new ArrayList<>();

    private AddressDTO addressDTO;

    private List<AttachmentDTO> attachmentDTOS = new ArrayList<>();

}
