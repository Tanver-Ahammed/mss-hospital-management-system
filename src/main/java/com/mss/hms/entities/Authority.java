package com.mss.hms.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    private String email;

    private int age;

    private String bloodGroup;

    private String address;

    private String password;

    private String role;

    private String verificationCode;

    private boolean isActive;

    @OneToOne(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id_fk", referencedColumnName = "id")
    private Attachment attachment;

}
