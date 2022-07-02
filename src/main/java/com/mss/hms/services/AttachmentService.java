package com.mss.hms.services;

import com.mss.hms.dto.AttachmentDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface AttachmentService {

    AttachmentDTO addAttachment(MultipartFile multipartFile) throws IOException;

}
