package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentDTO {

    private Long id;

    @NotEmpty(message = "department name can't be empty!!")
    @Size(min = 3, max = 100, message = "department's name must be min of 3 to 100 character")
    private String name;

    private List<UserDTO> doctors = new ArrayList<>();

}
