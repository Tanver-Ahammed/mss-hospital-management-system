package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DivisionDTO {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 20, message = "division's name must be min of 3 to 20 character")
    private String divisionName;

    private Set<DistrictDTO> districtDTOS;

}
