package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "doctor_patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DoctorPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private Date date;

    private Double price;

    private String role;

    private String verificationCode;

    private String address;

    @ManyToOne
    @JoinColumn(name = "doctor_patient_fk", referencedColumnName = "id")
    private Doctor doctor;

//    @OneToMany(mappedBy = "doctorPatient", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany
    private List<Attachment> attachments;

}
