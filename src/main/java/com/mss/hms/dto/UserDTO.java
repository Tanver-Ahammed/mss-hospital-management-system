package com.mss.hms.dto;

import jakarta.validation.constraints.*;
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

    @NotEmpty(message = "user's name can't be empty!!")
    @Size(min = 3, max = 100, message = "user's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "user's contact can't be empty!!")
    @Size(min = 3, max = 100, message = "user's contact must be min of 3 to 100 character")
    private String contact;

    private String email;

    @NotNull
    @Min(value = 0)
    @Max(value = 150)
    private Short age;

    private String bloodGroup;

    @NotEmpty(message = "user's address can't be empty!!")
    @Size(min = 3, max = 100, message = "user's address must be min of 3 to 100 character")
    private String address;

    @NotEmpty(message = "user's degree can't be empty!!")
    @Size(min = 3, max = 100, message = "user's degree must be min of 3 to 100 character")
    private String degree;

    @NotEmpty(message = "user's institution can't be empty!!")
    @Size(min = 3, max = 100, message = "user's institution must be min of 3 to 100 character")
    private String institution;

    private String verificationCode;

    private Boolean isActive;

    private Boolean isEnable;

    @Min(value = 0)
    @Max(value = 5000)
    private Integer visitPrice;

    @Size(min = 3, max = 100, message = "user's password must be min of 3 to 100 character")
    private String password;

    private List<RoleDTO> roles;

    private DepartmentDTO department;

    private AttachmentDTO attachment;

    private List<VisitedDayDTO> visitedDays;

}
