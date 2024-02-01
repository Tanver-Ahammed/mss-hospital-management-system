package com.mss.hms.services.impl;

import com.mss.hms.config.AppConstants;
import com.mss.hms.dto.AuthorityDTO;
import com.mss.hms.email.EmailSenderService;
import com.mss.hms.entities.Attachment;
import com.mss.hms.entities.Authority;
import com.mss.hms.repository.AttachmentRepository;
import com.mss.hms.repository.AuthorityRepository;
import com.mss.hms.services.AuthorityService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private AttachmentServiceImpl attachmentService;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    // registration authority
    @Override
    public AuthorityDTO registrationAuthority(AuthorityDTO authorityDTO, MultipartFile authorityImage)
            throws IOException {
        if (Objects.equals(authorityImage.getOriginalFilename(), "")) {
            return null;
        }

        Attachment attachment = this.modelMapper.map(this.attachmentService.addAttachment(authorityImage), Attachment.class);
        attachment.setAttachmentName("Image");

        authorityDTO.setActive(false);
        String verificationCode = RandomString.make(64);
        authorityDTO.setVerificationCode(verificationCode);

        Authority authority = this.modelMapper.map(authorityDTO, Authority.class);

        authority.setAttachment(attachment);

        this.authorityRepository.save(authority);

        String siteURL = AppConstants.host + "/blood/donor/verify";
//        sendVerificationEmail(authorityDTO, siteURL);

        return authorityDTO;
    }

    // send email for verification
    private void sendVerificationEmail(AuthorityDTO authorityDTO, String siteURL) {
        String subject = "Please, Verify your registration";
        siteURL += "/" + authorityDTO.getId() + "/" + authorityDTO.getVerificationCode();
        String emailContent = "<p><b>Dear " + authorityDTO.getName() + ",</b></p>"
                + "Please click the link below to verify your registration:<br>"
                + "<h1><a href=\"" + siteURL + "\" target=\"_self\">VERIFY</a></h1>"
                + "Thank you,<br>"
                + "MSS - Hospital Management System.";
        try {
            this.emailSenderService.sendEmailWithoutAttachment(authorityDTO.getEmail(), subject, emailContent);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
