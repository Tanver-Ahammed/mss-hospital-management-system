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

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "patient name can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "patient contact can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's contact must be min of 3 to 100 character")
    private String contact;

//    @Email
    private String email;

    @NotEmpty
    @Min(value = 0)
    @Max(value = 150)
    private Short age;

    private String bloodGroup;

    @Min(value = 0)
    @Max(value = 200)
    private Short weight;

    @NotEmpty
    private Date date;

    @NotEmpty
    private String verificationCode;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "patients_roles",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    @NotEmpty(message = "patient address can't be empty!!")
    @Size(min = 3, max = 100, message = "patient's address must be min of 3 to 100 character")
    private String address;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "patient", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    @OneToMany(mappedBy = "patient", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TestPatientHistory> testPatientHistories;

}
