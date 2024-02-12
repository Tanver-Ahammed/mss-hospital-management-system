package com.mss.hms.controller;

import com.mss.hms.dto.UserDTO;
import com.mss.hms.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/authority")
public class UserController {

    private final UserServiceImpl authorityService;

    @GetMapping(path = "/add")
    public String addAuthority(Model model) {
        model.addAttribute("authorityDTO", new UserDTO());
        model.addAttribute("message", "");
        return "authority/registration-authority";
    }

    @PostMapping(path = "/save")
    public String registrationAuthority(@Valid @ModelAttribute("authorityDTO") UserDTO authorityDTO, BindingResult result,
                                        @RequestParam("authorityImage") MultipartFile authorityImage,
                                        Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("authorityDTO", authorityDTO);
            return "authority/registration-authority";
        }

        UserDTO resultAuthorityDTO = this.authorityService.registrationAuthority(authorityDTO, authorityImage);

        // if image is not add
        if (resultAuthorityDTO == null) {
            model.addAttribute("authorityDTO", authorityDTO);
            model.addAttribute("message", "please enter authority image...");
            return "authority/registration-authority";
        }

        model.addAttribute("authorityDTO", new UserDTO());
        model.addAttribute("message", "authority is successfully added...");
        return "authority/registration-authority";
    }

}
