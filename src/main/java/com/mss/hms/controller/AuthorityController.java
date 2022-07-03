package com.mss.hms.controller;

import com.mss.hms.dto.AuthorityDTO;
import com.mss.hms.services.impl.AuthorityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping(path = "/authority")
public class AuthorityController {

    @Autowired
    private AuthorityServiceImpl authorityService;

    @GetMapping(path = "/add")
    public String addAuthority(Model model) {
        model.addAttribute("authorityDTO", new AuthorityDTO());
        model.addAttribute("message", "");
        return "authority/registration-authority";
    }

    @PostMapping(path = "/save")
    public String registration(@Valid @ModelAttribute("authorityDTO") AuthorityDTO authorityDTO, BindingResult result,
                               @RequestParam("authorityImage") MultipartFile authorityImage,
                               Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("authorityDTO", authorityDTO);
            return "authority/registration-authority";
        }

        AuthorityDTO resultAuthorityDTO = this.authorityService.registrationAuthority(authorityDTO, authorityImage);

        // if image is not add
        if (resultAuthorityDTO == null) {
            model.addAttribute("authorityDTO", authorityDTO);
            model.addAttribute("message", "please enter authority image...");
            return "authority/registration-authority";
        }

        model.addAttribute("authorityDTO", new AuthorityDTO());
        model.addAttribute("message", "authority is successfully added...");
        return "authority/registration-authority";
    }

}
