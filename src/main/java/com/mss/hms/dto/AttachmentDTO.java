package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long id;

    private String attachmentPath;

    private String attachmentName;

    @NotEmpty
    private String attachmentFileName;

    @NotEmpty
    private String attachmentType;

}
