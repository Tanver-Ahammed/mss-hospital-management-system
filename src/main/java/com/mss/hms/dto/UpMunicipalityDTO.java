package com.mss.hms.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpMunicipalityDTO {

    private Long id;

    private String upMunicipalityName;

    private UpZillaDTO upZillaDTO;

    private Set<VillageWardDTO> villageWardDTOS;

}
