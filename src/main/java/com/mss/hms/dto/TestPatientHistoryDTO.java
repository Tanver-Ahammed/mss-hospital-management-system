package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestPatientHistoryDTO {

    private Long id;

    @NotEmpty
    private Date date;

    @NotEmpty
    private Double price;

    @NotEmpty
    private Integer discount;

    private TestDTO test;

    private PatientDTO patient;

}
