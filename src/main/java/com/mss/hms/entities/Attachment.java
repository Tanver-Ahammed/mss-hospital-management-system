package com.mss.hms.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "attachments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attachment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "attachment name can't be empty!!")
    @Size(min = 3, max = 100, message = "attachment's name must be min of 3 to 100 character")
    private String name;

    @NotEmpty(message = "attachment file name can't be empty!!")
    @Size(min = 3, max = 100, message = "attachment's file name must be min of 3 to 100 character")
    private String fileName;

    @NotEmpty(message = "attachment type can't be empty!!")
    @Size(min = 3, max = 100, message = "attachment's type must be min of 3 to 100 character")
    private String type;

}
