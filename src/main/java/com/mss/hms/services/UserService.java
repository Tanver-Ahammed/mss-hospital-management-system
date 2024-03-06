package com.mss.hms.services;

import com.mss.hms.dto.UserDTO;
import com.mss.hms.entities.Role;
import com.mss.hms.message.email.EmailSenderService;
import com.mss.hms.entities.User;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.AttachmentRepository;
import com.mss.hms.repository.UserRepository;
import jakarta.mail.MessagingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AttachmentService attachmentService;

    private final EmailSenderService emailSenderService;

    private final ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    public UserService(UserRepository userRepository,
                       AttachmentService attachmentService,
                       AttachmentRepository attachmentRepository,
                       EmailSenderService emailSenderService,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.attachmentService = attachmentService;
        this.emailSenderService = emailSenderService;
        this.modelMapper = modelMapper;
    }

    // registration authority
    public UserDTO registrationUser(UserDTO userDTO, MultipartFile authorityImage)
            throws IOException {
        User user = this.dtoToUser(userDTO);
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setId(1L);
        roles.add(role);
        user.setIsActive(false);
        user.setIsEnable(false);
//        user.setRoles(roles);
        user.setVerificationCode("65456456454684");
        this.userRepository.save(user);
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        return null;
    }

    public UserDTO getSingleUserById(Long userId) {
        return null;
    }

    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        return null;
    }

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
