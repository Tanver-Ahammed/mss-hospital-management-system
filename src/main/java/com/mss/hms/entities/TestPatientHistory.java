package com.mss.hms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "test_patient_histories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestPatientHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "test_id_fk", referencedColumnName = "id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "test_patient_id_fk", referencedColumnName = "id")
    private TestPatient testPatient;

}
