package com.mss.hms.controller;

import com.mss.hms.dto.DoctorDTO;
import com.mss.hms.services.impl.DepartmentServiceImpl;
import com.mss.hms.services.impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping(path = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping(path = "/add")
    public String addDoctor(Model model) {
        model.addAttribute("doctorDTO", new DoctorDTO());
        model.addAttribute("departmentDTOS", this.departmentService.getAllDepartment());
        model.addAttribute("message", "");
        return "doctor/registration-doctor";
    }

    @PostMapping(path = "/save")
    public String registrationDoctor(/*@Valid */@ModelAttribute("doctorDTO") DoctorDTO doctorDTO, BindingResult result,
                                     @RequestParam("doctorImage") MultipartFile doctorImage,
                                     Model model) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("doctorDTO", doctorDTO);
            System.err.println(result);
            return "doctor/registration-doctor";
        }

        System.err.println(doctorDTO.getDepartmentDTO());

        DoctorDTO resultDoctorDTO = this.doctorService.registrationDoctor(doctorDTO, doctorImage);

        // if image is not add
        if (resultDoctorDTO == null) {
            model.addAttribute("doctorDTO", doctorDTO);
            model.addAttribute("message", "please enter doctor image...");
            return "doctor/registration-doctor";
        }

        model.addAttribute("doctorDTO", new DoctorDTO());
        model.addAttribute("message", "doctor is successfully added...");
        return "doctor/registration-doctor";
    }


}
