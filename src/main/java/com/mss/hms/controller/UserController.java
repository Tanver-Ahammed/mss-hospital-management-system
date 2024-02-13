package com.mss.hms.controller;

import com.mss.hms.dto.UserDTO;
import com.mss.hms.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/registration")
    public ResponseEntity<UserDTO> registrationUser(@RequestBody UserDTO userDTO) throws IOException {
        return new ResponseEntity<>(this.userService.registrationUser(userDTO, null), HttpStatus.CREATED);
    }


}
