package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "test_patient_histories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestPatientHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private Date date;

    @NotEmpty
    private Double price;

    @NotEmpty
    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "test_id_fk", referencedColumnName = "id")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "test_patient_id_fk", referencedColumnName = "id")
    private Patient patient;

}
