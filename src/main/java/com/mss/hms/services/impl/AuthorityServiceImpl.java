package com.mss.hms.services.impl;

import com.mss.hms.config.AppConstants;
import com.mss.hms.dto.AuthorityDTO;
import com.mss.hms.entities.Authority;
import com.mss.hms.repository.AuthorityRepository;
import com.mss.hms.services.AuthorityService;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private ModelMapper modelMapper;

    @Value("${project.image}")
    private String path;

    // registration authority
    @Override
    public AuthorityDTO registrationAuthority(AuthorityDTO authorityDTO, MultipartFile authorityImage) throws IOException {
        if (Objects.equals(authorityImage.getOriginalFilename(), "")) {
            return null;
        }
        String bloodDonorImageName = this.fileService.uploadImage(path, authorityImage);
//        authorityDTO.set(bloodDonorImageName);
//        bloodDonorDTO.setAvailable(false);
        String verificationCode = RandomString.make(64);
//        bloodDonorDTO.setVerificationCode(verificationCode);
        Authority authority = this.modelMapper.map(authorityDTO, Authority.class);
        authorityDTO = this.modelMapper.map(this.authorityRepository.save(authority), AuthorityDTO.class);
        String siteURL = AppConstants.host + "/blood/donor/verify";
//        sendVerificationEmail(bloodDonorDTO, siteURL);
        return authorityDTO;
    }
}
