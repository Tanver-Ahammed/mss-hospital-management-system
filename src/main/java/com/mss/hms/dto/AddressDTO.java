package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "address must be min of 3 to 100 character")
    private String addressName;

}
