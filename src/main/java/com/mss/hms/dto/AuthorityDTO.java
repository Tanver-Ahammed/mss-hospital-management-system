package com.mss.hms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthorityDTO {

    private Long id;

    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private String address;

    private String password;

    private String role;

    private String verificationCode;

    private boolean isActive;

    private AttachmentDTO attachmentDTO;

}
