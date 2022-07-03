package com.mss.hms.dto;

import com.mss.hms.entities.Authority;
import com.mss.hms.entities.Doctor;
import com.mss.hms.entities.DoctorPatient;
import com.mss.hms.entities.TestPatient;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long id;

    private String attachmentPath;

    private String attachmentName;

    @NotEmpty
    private String attachmentFileName;

    @NotEmpty
    private String attachmentType;

}
