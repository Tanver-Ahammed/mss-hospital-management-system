package com.mss.hms.controller;

import com.mss.hms.dto.DistrictDTO;
import com.mss.hms.dto.DivisionDTO;
import com.mss.hms.services.impl.DistrictServiceImpl;
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
@RequestMapping(path = "/district")
public class DistrictController {

    @Autowired
    private DivisionServiceImpl divisionService;

    @Autowired
    private DistrictServiceImpl districtService;

    @GetMapping(path = "/add")
    public String addDistrict(Model model) {
        model.addAttribute("districtDTO", new DistrictDTO());
        model.addAttribute("divisionDTOS", this.divisionService.getAllDivision());
        return "add-district";
    }

    @PostMapping(path = "/save")
    public String saveDistrict(@Valid @ModelAttribute("districtDTO") DistrictDTO districtDTO,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bloodDonorDTO", districtDTO);
            System.err.println(result);
            return "add-district";
        }
        this.districtService.addDistrict(districtDTO);
        model.addAttribute("districtDTO", new DistrictDTO());
        model.addAttribute("message", "district is successfully added...");
        return "add-district";
    }

}
