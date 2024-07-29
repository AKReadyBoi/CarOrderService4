package com.innowise.ryabov.cos4.service;
import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.request.UserRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface UserService {
    List<UserDTO> getAllUsers();
    void saveUser(UserRequest user);
    UserDTO updateUser(Long id,UserRequest userRequest);
    void deleteUser(Long id);
    UserDTO getUser(Long id);

}
