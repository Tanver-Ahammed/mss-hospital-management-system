package com.mss.hms.services;

import com.mss.hms.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface UserService {

    // registration authority
    UserDTO registrationAuthority(UserDTO authorityDTO, MultipartFile authorityImage) throws IOException;

}
