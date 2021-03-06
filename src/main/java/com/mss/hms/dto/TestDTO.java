package com.mss.hms.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 100, message = "test's name must be min of 3 to 100 character")
    private String name;

    private int price;

    private boolean isActive;

    private List<TestPatientHistoryDTO> testVsPatientHistoryDTOS = new ArrayList<>();

}
