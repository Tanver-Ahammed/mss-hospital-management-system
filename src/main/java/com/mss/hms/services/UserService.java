package com.mss.hms.services;

import com.mss.hms.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {

    // registration authority
    UserDTO registrationUser(UserDTO authorityDTO, MultipartFile authorityImage) throws IOException;

    List<UserDTO> getAllUsers();

    UserDTO getSingleUserById(Long userId);

    UserDTO updateUser(UserDTO userDTO, Long userId);

    boolean deleteUser(Long userId);

}
