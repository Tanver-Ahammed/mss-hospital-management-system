package com.mss.hms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VillageWardDTO {

    private Long id;

    private String villageWardName;

    private UpMunicipalityDTO upMunicipalityDTO;

}
