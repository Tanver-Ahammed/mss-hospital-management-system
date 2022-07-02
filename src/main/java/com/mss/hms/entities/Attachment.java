package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attachments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Attachment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "attachment_name")
    private String attachmentName;

    @Column(name = "attachment_file_name")
    private String attachmentFileName;

    @Column(name = "attachment_type")
    private String attachmentType;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id_fk", referencedColumnName = "id")
//    private Doctor doctor;

//    @ManyToOne
//    @JoinColumn(name = "doctor_Patient_id_fk", referencedColumnName = "id")
//    private DoctorPatient doctorPatient;

//    @ManyToOne
//    @JoinColumn(name = "test_patient_id_fk", referencedColumnName = "id")
//    private TestPatient testPatient;

//    @ManyToOne
//    @JoinColumn(name = "authority_id_fk", referencedColumnName = "id")
//    private Authority authority;

}
