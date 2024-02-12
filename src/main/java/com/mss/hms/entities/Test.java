package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tests")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "test name can't be empty!!")
    @Size(min = 3, max = 100, message = "test's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "department name can't be empty!!")
    @Min(value = 0)
    @Max(value = 50000)
    private Double price;

    private Boolean isActive;

    @OneToMany(mappedBy = "test", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TestPatientHistory> testVsPatientHistories;

}
