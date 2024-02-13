package com.mss.hms.dto;

import com.mss.hms.entities.Role;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {

    private Long id;

    @NotEmpty(message = "patient name can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "patient contact can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's contact must be min of 3 to 100 character")
    private String contact;

    // @Email
    private String email;

    @NotEmpty
    @Min(value = 0)
    @Max(value = 150)
    private Short age;

    private String bloodGroup;

    @Min(value = 0)
    @Max(value = 200)
    private Short weight;

    @NotEmpty
    private Date date;

    private String verificationCode;

    private List<Role> roles;

    @NotEmpty(message = "patient address can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's address must be min of 3 to 100 character")
    private String address;

    private List<AttachmentDTO> attachments;

    private List<PrescriptionDTO> prescriptions;

    private List<TestPatientHistoryDTO> testPatientHistories;

}
