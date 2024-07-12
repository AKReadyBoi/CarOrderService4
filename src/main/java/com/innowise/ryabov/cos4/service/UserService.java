package com.innowise.ryabov.cos4.service;
import com.innowise.ryabov.cos4.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUsers();
}
