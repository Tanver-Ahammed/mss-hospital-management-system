package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotEmpty(message = "prescription date can't be empty!!")
    private Date date;

    @NotEmpty(message = "prescription serial no can't be empty!!")
    private Integer serialNo;

    @NotEmpty(message = "prescription price can't be empty!!")
    private Double price;

    @NotEmpty(message = "prescription date can't be empty!!")
    private int discount;

    @NotEmpty
    private Boolean isApproveByDoctor;

    @ManyToOne
    @JoinColumn(name = "test_id_fk", referencedColumnName = "id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "doctor_patient_id_fk", referencedColumnName = "id")
    private Patient patient;

    @OneToMany(mappedBy = "prescription", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Medicine> medicines = new ArrayList<>();

}
