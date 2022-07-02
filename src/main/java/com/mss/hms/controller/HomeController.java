package com.mss.hms.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = {"/", "/home"})
    public String home() {
        return "home";
    }


    @GetMapping(path = "/developer")
    public String developer() {
        return "developer";
    }


}
