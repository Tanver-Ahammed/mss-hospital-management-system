package com.mss.hms.controller;

import com.mss.hms.dto.RoleDTO;
import com.mss.hms.dto.UserDTO;
import com.mss.hms.dto.VisitedDayDTO;
import com.mss.hms.services.RoleService;
import com.mss.hms.services.UserService;
import com.mss.hms.services.VisitedDayService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    private RoleService roleService;

    private VisitedDayService visitedDayService;

    @GetMapping("/registration")
    public String registrationUser(Principal principal, Model model) {
        UserDTO user = new UserDTO();
        List<RoleDTO> roles = this.roleService.getAllRoles();
        List<VisitedDayDTO> visitedDays = this.visitedDayService.getAllVisitedDays();
        model.addAttribute("roles", roles);
        model.addAttribute("visitedDays", visitedDays);
        model.addAttribute("userDTO", user);
        model.addAttribute("message", "");
        return "user/registration";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("userDTO") UserDTO user, BindingResult result,
                           Model model, Principal principal) throws IOException {
        System.out.println(user.toString());
        if (result.hasErrors())
            System.err.println("Tanver Ahammed");

        this.userService.registrationUser(user, null);

        return "redirect:/user/registration";
    }

}
