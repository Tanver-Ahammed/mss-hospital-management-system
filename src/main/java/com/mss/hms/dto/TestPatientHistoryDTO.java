package com.mss.hms.dto;

import com.mss.hms.entities.Test;
import com.mss.hms.entities.TestPatient;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TestPatientHistoryDTO {

    private Long id;

    private Date date;

    private Double price;

    private Test test;

    private TestPatient testPatient;

}
