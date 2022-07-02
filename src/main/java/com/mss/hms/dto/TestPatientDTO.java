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
public class TestPatientDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "test patient's name must be min of 3 to 100 character")
    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private String role;

    private String verificationCode;

    private String address;

    private List<AttachmentDTO> attachment = new ArrayList<>();

    private List<TestPatientHistoryDTO> testVsPatientHistoryDTOS = new ArrayList<>();

}
