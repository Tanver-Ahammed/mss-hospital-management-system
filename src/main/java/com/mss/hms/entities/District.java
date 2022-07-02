package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "districts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String districtName;

    @ManyToOne
    @JoinColumn(name = "division_id_fk", referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "district", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UpZilla> upZillas;

}
