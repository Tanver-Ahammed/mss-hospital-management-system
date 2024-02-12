package com.mss.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String name;

    private String contact;

    private String email;

    private Short age;

    private String bloodGroup;

    private String address;

    private String degree;

    private String institution;

    private Integer visitPrice;

    private String password;

    private List<RoleDTO> roles;

    private String verificationCode;

    private Boolean isActive;

    private Boolean isEnable;

    private DepartmentDTO department;

    private AttachmentDTO attachment;

    private List<VisitedDayDTO> visitedDays;

}
