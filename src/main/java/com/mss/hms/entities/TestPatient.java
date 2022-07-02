package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "test_patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private Date date;

    private String role;

    private String verificationCode;

    private String address;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attachment> attachment = new ArrayList<>();

    //    @OneToMany(mappedBy = "testPatient", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OneToMany
    private List<TestPatientHistory> testVsPatientHistories = new ArrayList<>();

}
