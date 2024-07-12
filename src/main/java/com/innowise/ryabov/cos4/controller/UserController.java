package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.User;
import com.innowise.ryabov.cos4.service.serviceImplementation.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/saveUser/")
    public HttpStatusCode saveUser(User user) {
        userService.saveUser(user);
        return HttpStatusCode.valueOf(201);
    }
}
