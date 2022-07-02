package com.mss.hms.controller;

import com.mss.hms.dto.DivisionDTO;
import com.mss.hms.services.impl.DivisionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/division")
public class DivisionController {

    @Autowired
    private DivisionServiceImpl divisionService;

    @GetMapping(path = "/add")
    public String addDivision(Model model) {
        model.addAttribute("divisionDTO", new DivisionDTO());
        return "add-division";
    }

    @PostMapping(path = "/save")
    public String saveDivision(@Valid @ModelAttribute("divisionDTO") DivisionDTO divisionDTO,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bloodDonorDTO", divisionDTO);
            System.err.println(result);
            return "add-division";
        }
        this.divisionService.addDivision(divisionDTO);
        model.addAttribute("divisionDTO", new DivisionDTO());
        model.addAttribute("message", "division is successfully added...");
        return "add-division";
    }


}
