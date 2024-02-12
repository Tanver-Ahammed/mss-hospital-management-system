package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttachmentDTO {

    private Long id;

    @NotEmpty(message = "attachment name can't be empty!!")
    private String attachmentName;

    @NotEmpty(message = "attachment file name can't be empty!!")
    private String attachmentFileName;

    @NotEmpty(message = "attachment name type can't be empty!!")
    private String attachmentType;

}
