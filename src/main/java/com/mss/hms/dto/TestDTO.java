package com.mss.hms.dto;

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

    private String name;

    private Double price;

    private Boolean isActive;

    private List<TestPatientHistoryDTO> testVsPatientHistories;

}
