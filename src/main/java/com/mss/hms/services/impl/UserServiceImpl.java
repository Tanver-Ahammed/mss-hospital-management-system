package com.mss.hms.services.impl;

import com.mss.hms.dto.UserDTO;
import com.mss.hms.email.EmailSenderService;
import com.mss.hms.entities.User;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.AttachmentRepository;
import com.mss.hms.repository.UserRepository;
import com.mss.hms.services.UserService;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AttachmentServiceImpl attachmentService;

    private final EmailSenderService emailSenderService;

    private final ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    public UserServiceImpl(UserRepository userRepository,
                           AttachmentServiceImpl attachmentService,
                           AttachmentRepository attachmentRepository,
                           EmailSenderService emailSenderService,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.attachmentService = attachmentService;
        this.emailSenderService = emailSenderService;
        this.modelMapper = modelMapper;
    }

    // registration authority
    @Override
    public UserDTO registrationUser(UserDTO userDTO, MultipartFile authorityImage)
            throws IOException {


        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return null;
    }

    @Override
    public UserDTO getSingleUserById(Long userId) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }

    protected User getUserById(Long userId) {
        return this.userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", userId)
        );
    }

    protected UserDTO userToDTO(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }

    protected User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

    // send email for verification
    private void sendVerificationEmail(UserDTO authorityDTO, String siteURL) {
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
