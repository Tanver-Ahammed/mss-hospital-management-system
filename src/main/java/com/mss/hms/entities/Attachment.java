package com.mss.hms.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "attachments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Attachment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "attachment_name")
    private String attachmentName;

    @Column(name = "attachment_file_name")
    private String attachmentFileName;

    @Column(name = "attachment_type")
    private String attachmentType;

}
