package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoctorPatientDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "doctor patient's name must be min of 3 to 100 character")
    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private Date date;

    private Double price;

    private String role;

    private String verificationCode;

    private DoctorDTO doctorDTO;

    private String address;

    private List<AttachmentDTO> attachmentDTOS;

}
