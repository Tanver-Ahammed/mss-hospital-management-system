package com.mss.hms.services;

import com.mss.hms.dto.AuthorityDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface AuthorityService {

    // registration authority
    AuthorityDTO registrationAuthority(AuthorityDTO authorityDTO, MultipartFile authorityImage) throws IOException;

}
