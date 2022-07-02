package com.mss.hms.dto;

import com.mss.hms.entities.Address;
import com.mss.hms.entities.Attachment;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthorityDTO {

    private Long id;

    private String name;

    private String email;

    private String contact;

    private int age;

    private String bloodGroup;

    private String password;

    private String role;

    private String verificationCode;

    private boolean isActive;

    private AddressDTO addressDTO;

    private List<AttachmentDTO> attachmentDTOS = new ArrayList<>();

}
