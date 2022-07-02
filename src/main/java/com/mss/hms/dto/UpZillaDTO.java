package com.mss.hms.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpZillaDTO {

    private Long id;

    private String upZillaName;

    private DistrictDTO districtDTO;

    private Set<UpMunicipalityDTO> upMunicipalityDTOS;

}
