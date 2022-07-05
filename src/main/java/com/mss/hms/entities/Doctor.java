package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEnglish;

    private String nameBengali;

    private String contact;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id_fk", referencedColumnName = "id")
    private Department department;

    private String degreeEnglish;

    private String degreeBengali;

    private String titleEnglish;

    private String titleBengali;

    private String institutionEnglish;

    private String institutionBengali;

    private int age;

    private String bloodGroup;

    private Integer price;

    private String role;

    private String verificationCode;

    private boolean isActive;

    private String address;

    private String password;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id_fk", referencedColumnName = "id")
    private Attachment attachment;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DoctorPatient> doctorPatients = new ArrayList<>();

}
