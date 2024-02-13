package com.mss.hms.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestDTO {

    private Long id;

    @NotEmpty(message = "test name can't be empty!!")
    @Size(min = 3, max = 100, message = "test's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "department name can't be empty!!")
    @Min(value = 0)
    @Max(value = 50000)
    private Double price;

    @NotEmpty
    private Boolean isActive;

    private List<TestPatientHistoryDTO> testVsPatientHistories;

}
