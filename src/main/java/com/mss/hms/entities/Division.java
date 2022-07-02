package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "divisions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String divisionName;

    @OneToMany(mappedBy = "division", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<District> districts;

}
