package com.mss.hms.controller;

import com.mss.hms.dto.DepartmentDTO;
import com.mss.hms.dto.RoleDTO;
import com.mss.hms.dto.UserDTO;
import com.mss.hms.dto.VisitedDayDTO;
import com.mss.hms.services.DepartmentService;
import com.mss.hms.services.RoleService;
import com.mss.hms.services.UserService;
import com.mss.hms.services.VisitedDayService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    private RoleService roleService;

    private DepartmentService departmentService;

    private VisitedDayService visitedDayService;

    @GetMapping("/registration")
    public String registrationUser(Principal principal, Model model) {
        UserDTO user = new UserDTO();
        List<RoleDTO> roles = this.roleService.getAllRoles();
        List<VisitedDayDTO> visitedDays = this.visitedDayService.getAllVisitedDays();
        List<DepartmentDTO> departments = this.departmentService.getAllDepartment();
        model.addAttribute("userDTO", user);
        model.addAttribute("departments", departments);
        model.addAttribute("roles", roles);
        model.addAttribute("visitedDays", visitedDays);
        model.addAttribute("message", "");
        return "user/registration";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result,
                           @RequestParam(value = "roles", required = false) Long roles,
                           @RequestParam(value = "department", required = false) Long department,
                           @RequestParam(value = "visitedDays", required = false) Long[] visitedDays,
                           @RequestParam(value = "attachment", required = false) MultipartFile profilePhoto,
                           Model model, Principal principal) throws IOException {

        this.userService.registrationUser(userDTO, new Long[]{roles}, department, visitedDays, profilePhoto);

        return "redirect:/user/registration";
    }

}
