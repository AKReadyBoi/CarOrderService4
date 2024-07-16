package com.innowise.ryabov.cos4.service;
import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.request.UserRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUsers();
    void saveUser(Users user);
    Users updateUser(Long id, UserRequest userRequest);
    void deleteUser(Long id);

}
