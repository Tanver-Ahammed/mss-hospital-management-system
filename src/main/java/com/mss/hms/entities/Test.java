package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private boolean isActive;

    @OneToMany(mappedBy = "test", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TestPatientHistory> testVsPatientHistories = new ArrayList<>();

}
