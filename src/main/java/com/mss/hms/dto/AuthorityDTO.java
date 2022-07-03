package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.*;

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
