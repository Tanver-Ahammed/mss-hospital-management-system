package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "department name can't be empty!!")
    @Size(min = 3, max = 100, message = "department's name must be min of 3 to 100 character")
    private String name;

    @OneToMany(mappedBy = "department", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> doctors;

}
