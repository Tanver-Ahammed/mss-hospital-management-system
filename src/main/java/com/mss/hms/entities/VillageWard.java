package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "village_wards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VillageWard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String villageWardName;

    @ManyToOne
    @JoinColumn(name = "upMunicipality_id_fk", referencedColumnName = "id")
    private UpMunicipality upMunicipality;

}
