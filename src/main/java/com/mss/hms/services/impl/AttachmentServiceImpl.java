package com.mss.hms.services.impl;

import com.mss.hms.dto.AttachmentDTO;
import com.mss.hms.repository.AttachmentRepository;
import com.mss.hms.services.AttachmentService;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    @Override
    public AttachmentDTO addAttachment(MultipartFile multipartFile) throws IOException {
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        if (Objects.equals(multipartFile.getOriginalFilename(), "")) {
            return null;
        }

        String originalFileName = this.fileService.uploadImage(path, multipartFile);
        attachmentDTO.setAttachmentFileName(originalFileName);

        String extension = FilenameUtils.getExtension(originalFileName);
        attachmentDTO.setAttachmentType(extension);

        attachmentDTO.setAttachmentPath(path);

        // CascadeType = MERGE
//        Attachment attachment = this.attachmentRepository.save(this.modelMapper.map(attachmentDTO,
//                Attachment.class));
//        attachmentDTO = this.modelMapper.map(attachment, AttachmentDTO.class);

        return attachmentDTO;
    }

}
