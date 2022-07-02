package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "up_zillas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpZilla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String upZillaName;

    @ManyToOne
    @JoinColumn(name = "district_id_fk", referencedColumnName = "id")
    private District district;

    @OneToMany(mappedBy = "upZilla", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UpMunicipality> upMunicipalities;

}
