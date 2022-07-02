package com.mss.hms.dto;

import lombok.*;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long id;

    private String attachmentName;

    private String attachmentPath;

    private String attachmentType;

}
