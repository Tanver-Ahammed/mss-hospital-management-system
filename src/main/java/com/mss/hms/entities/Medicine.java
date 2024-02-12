package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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

    @NotEmpty(message = "medicine name can't be empty!!")
    @Size(min = 3, max = 100, message = "medicine's name must be min of 3 to 100 character")
    private String name;

    private String companyName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "prescription_id_fk", referencedColumnName = "id")
    private Prescription prescription;

}
