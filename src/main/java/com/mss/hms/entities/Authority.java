package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String contact;

    private int age;

    private String bloodGroup;

    private String password;

    private String role;

    private String verificationCode;

    private boolean isActive;

    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "authority", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attachment> attachments = new ArrayList<>();

}
