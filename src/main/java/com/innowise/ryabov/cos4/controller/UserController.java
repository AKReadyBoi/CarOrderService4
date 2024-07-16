package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/saveUser")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody Users user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Long id, @RequestBody Users userDetails)  {
        Users user = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable(value = "id") Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
