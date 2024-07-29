package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.request.UserRequest;
import com.innowise.ryabov.cos4.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    UserService userService;
    @GetMapping("/get")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody @Valid UserRequest user) {
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userDetails) {
        UserDTO user = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
