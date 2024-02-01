package com.mss.hms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthorityDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 50, message = "authority's name must be min of 3 to 50 character")
    private String name;

    @NotBlank
    private String contact;

    private String email;

    @Min(value = 18, message = "blood donor's age must be minimum 18 years")
    @Max(value = 100, message = "blood donor's age must be maximum 50 years")
    private int age;

    private String bloodGroup;

    @NotBlank
    private String address;

    private String password;

    @NotBlank
    private String role;

    private String verificationCode;

    private boolean isActive;

    private AttachmentDTO attachmentDTO;

}
