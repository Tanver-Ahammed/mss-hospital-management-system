package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestPatientDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "test patient's name must be min of 3 to 100 character")
    private String name;

    @NotBlank
    private String contact;

    private String email;

    @Min(value = 0, message = "blood donor's age must be minimum 0 years")
    @Max(value = 130, message = "blood donor's age must be maximum 130 years")
    private int age;

    private String bloodGroup;

    private String address;

    private String role;

    private String verificationCode;

    private List<AttachmentDTO> attachment = new ArrayList<>();

    private List<TestPatientHistoryDTO> testVsPatientHistoryDTOS = new ArrayList<>();

}
