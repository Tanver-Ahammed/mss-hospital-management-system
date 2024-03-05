package com.mss.hms.controller;

import com.mss.hms.dto.DepartmentDTO;
import com.mss.hms.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/add")
    public String addDepartment(Model model) {
        model.addAttribute("departmentDTO", new DepartmentDTO());
        model.addAttribute("message", "");
        return "department/add-department";
    }

    @PostMapping(path = "/save")
    public String saveDepartment(@Valid @ModelAttribute("departmentDTO") DepartmentDTO departmentDTO,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("departmentDTO", departmentDTO);
            model.addAttribute("message", "");
            return "department/add-department";
        }
        departmentDTO = this.departmentService.addDepartment(departmentDTO);
        model.addAttribute("departmentDTO", new DepartmentDTO());
        model.addAttribute("message", "department is successfully added...");
        return "department/add-department";
    }

    // get all department
    @GetMapping(path = "/all")
    public String getAllDepartment(Model model) {
        List<DepartmentDTO> departmentDTOS = this.departmentService.getAllDepartment();
        model.addAttribute("departmentDTOS", departmentDTOS);
        model.addAttribute("message", "");
        return "department/get-all-department";
    }

    // edit department
    @GetMapping(path = "/edit/{departmentId}")
    public String editDepartment(@PathVariable("departmentId") Long departmentId, Model model) {
        DepartmentDTO departmentDTO = this.departmentService.getSingleDepartmentById(departmentId);
        model.addAttribute("departmentDTO", departmentDTO);
        model.addAttribute("message", "");
        return "department/update-department";
    }

    // update department
    @PostMapping(path = "/update/{departmentId}")
    public String updateDepartment(@Valid @ModelAttribute("departmentDTO") DepartmentDTO departmentDTO, BindingResult result,
                                   @PathVariable("departmentId") Long departmentId,
                                   Model model) {

        if (result.hasErrors()) {
            model.addAttribute("departmentDTO", departmentDTO);
            model.addAttribute("message", "");
            return "department/update-department";
        }
        departmentDTO = this.departmentService.updateDepartment(departmentDTO, departmentId);    // save the department database
        model.addAttribute("bookDTO", new DepartmentDTO());
        model.addAttribute("message", "");
        return "redirect:/department/all";

    }

}
