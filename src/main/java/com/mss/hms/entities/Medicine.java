package com.mss.hms.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String companyName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "prescription_id_fk", referencedColumnName = "id")
    private Prescription prescription;

}
