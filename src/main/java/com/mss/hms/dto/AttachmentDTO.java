package com.mss.hms.dto;

import com.mss.hms.entities.Authority;
import com.mss.hms.entities.Doctor;
import com.mss.hms.entities.DoctorPatient;
import com.mss.hms.entities.TestPatient;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long id;

    private String attachmentPath;

    private String attachmentName;

    private String attachmentFileName;

    private String attachmentType;

}
