package com.mss.hms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "prescriptions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Short serialNo;

    private Double price;

    private int discount;

    @ManyToOne
    @JoinColumn(name = "test_id_fk", referencedColumnName = "id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "doctor_patient_id_fk", referencedColumnName = "id")
    private Patient patient;

    @OneToMany(mappedBy = "prescription", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medicine> medicines = new ArrayList<>();

}
