package com.mss.hms.services;

import com.mss.hms.dto.UserDTO;
import com.mss.hms.entities.Attachment;
import com.mss.hms.entities.Role;
import com.mss.hms.entities.VisitedDay;
import com.mss.hms.message.email.EmailSenderService;
import com.mss.hms.entities.User;
import com.mss.hms.exception.ResourceNotFoundException;
import com.mss.hms.repository.UserRepository;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AttachmentService attachmentService;

    private final RoleService roleService;

    private final DepartmentService departmentService;

    private final VisitedDayService visitedDayService;

    private final EmailSenderService emailSenderService;

    private final ModelMapper modelMapper;

    // registration authority
    public void registrationUser(UserDTO userDTO, Long[] roles, Long departmentId, Long[] visitedDays, MultipartFile profilePhoto)
            throws IOException {

        // image upload
        if (Objects.equals(profilePhoto.getOriginalFilename(), "")) {
            return;
        }
        Attachment attachment = this.modelMapper
                .map(this.attachmentService.addAttachment(profilePhoto), Attachment.class);
        attachment.setName("Image");

        User user = this.dtoToUser(userDTO);
        user.setAttachment(attachment);

        // role set
        List<Role> roleList = new ArrayList<>();
        roleList.add(this.roleService.getRoleById(roles[0]));
        user.setRoles(roleList);

        // department set
        user.setDepartment(departmentService.getDepartmentById(departmentId));

        // doctor visited date set
        List<VisitedDay> visitedDaysList = new ArrayList<>();
        for (Long visitedDay : visitedDays) {
            visitedDaysList.add(this.visitedDayService.getVisitedDayById(visitedDay));
        }
        user.setVisitedDays(visitedDaysList);

        user.setIsActive(false);
        user.setIsEnable(false);
        String verificationCode = RandomString.make(64);
        user.setVerificationCode(verificationCode);

        // save user
        this.userRepository.save(user);
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
