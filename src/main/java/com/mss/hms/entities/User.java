package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "user's name can't be empty!!")
    @Size(min = 3, max = 100, message = "user's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "user's contact can't be empty!!")
    @Size(min = 3, max = 100, message = "user's contact must be min of 3 to 100 character")
    private String contact;

    @Email
    private String email;

    @NotEmpty
    @Min(value = 0)
    @Max(value = 150)
    private Short age;

    private String bloodGroup;

    @NotEmpty(message = "user's address can't be empty!!")
    @Size(min = 3, max = 100, message = "user's address must be min of 3 to 100 character")
    private String address;

    @NotEmpty(message = "user's degree can't be empty!!")
    @Size(min = 3, max = 100, message = "user's degree must be min of 3 to 100 character")
    private String degree;

    @NotEmpty(message = "user's institution can't be empty!!")
    @Size(min = 3, max = 100, message = "user's institution must be min of 3 to 100 character")
    private String institution;

    @Min(value = 0)
    @Max(value = 5000)
    private Integer visitPrice;

    @Size(min = 3, max = 100, message = "user's password must be min of 3 to 100 character")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

    private String verificationCode;

    @NotEmpty
    private Boolean isActive;

    @NotEmpty
    private Boolean isEnable;

    @ManyToOne
    @JoinColumn(name = "department_id_fk", referencedColumnName = "id")
    private Department department;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id_fk", referencedColumnName = "id")
    private Attachment attachment;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_visited_day",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "day_id", referencedColumnName = "id")
    )
    private List<VisitedDay> visitedDays;

}
