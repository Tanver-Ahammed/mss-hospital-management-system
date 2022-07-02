package com.mss.hms.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DistrictDTO {

    private Long id;

    private String districtName;

    private DivisionDTO divisionDTO;

    private Set<UpZillaDTO> upZillaDTOS;

}
