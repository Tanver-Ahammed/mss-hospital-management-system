package com.mss.hms.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    private ModelMapper modelMapper;

    @GetMapping(path = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/feature")
    public String feature() {
        return "feature";
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/team")
    public String team() {
        return "team";
    }

    @GetMapping("/appointment")
    public String appointment() {
        return "appointment";
    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }

    @GetMapping("/404")
    public String error() {
        return "404";
    }

    @GetMapping(path = "/developer")
    public String developer() {
        return "developer";
    }

}
