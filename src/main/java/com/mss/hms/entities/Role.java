package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "role's type can't be empty!!")
    @Size(min = 3, max = 100, message = "role's type must be min of 3 to 100 character")
    private String roleType;

    @NotEmpty(message = "role's name can't be empty!!")
    @Size(min = 3, max = 100, message = "role's name must be min of 3 to 100 character")
    private String roleName;

}
