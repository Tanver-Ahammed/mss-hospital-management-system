package com.mss.hms.dto;

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

    private Date date;

    private Double price;

    private Integer discount;

    private TestDTO test;

    private PatientDTO patient;

}
