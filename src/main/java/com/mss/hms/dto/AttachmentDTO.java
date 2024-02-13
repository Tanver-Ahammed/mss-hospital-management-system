package com.mss.hms.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @Size(min = 3, max = 100, message = "attachment's name must be min of 3 to 100 character")
    private String attachmentName;

    @NotEmpty(message = "attachment file name can't be empty!!")
    @Size(min = 3, max = 100, message = "attachment's file name must be min of 3 to 100 character")
    private String attachmentFileName;

    @NotEmpty(message = "attachment type can't be empty!!")
    @Size(min = 3, max = 100, message = "attachment's type must be min of 3 to 100 character")
    private String attachmentType;

}
