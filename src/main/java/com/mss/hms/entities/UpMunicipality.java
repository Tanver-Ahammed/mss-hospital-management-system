package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "up_municipalities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpMunicipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String upMunicipalityName;

    @ManyToOne
    @JoinColumn(name = "upZilla_id_fk", referencedColumnName = "id")
    private UpZilla upZilla;

    @OneToMany(mappedBy = "upMunicipality", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VillageWard> villageWards;

}

