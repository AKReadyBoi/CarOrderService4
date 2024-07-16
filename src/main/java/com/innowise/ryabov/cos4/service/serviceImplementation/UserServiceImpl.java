package com.innowise.ryabov.cos4.service.serviceImplementation;

import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.mapper.UserMapper;
import com.innowise.ryabov.cos4.repository.UserRepository;
import com.innowise.ryabov.cos4.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(Users user) {
        userRepository.save(user);
    }
    @Override
    public Users updateUser(Long id, Users userDetails) {
        Users user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found for this id : " + id));
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteAllById(Collections.singleton(id));
    }

}
