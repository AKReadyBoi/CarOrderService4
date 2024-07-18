package com.innowise.ryabov.cos4.service.impl;
import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.mapper.UserMapper;
import com.innowise.ryabov.cos4.messages.PropertyUtil;
import com.innowise.ryabov.cos4.repository.UserRepository;
import com.innowise.ryabov.cos4.request.UserRequest;
import com.innowise.ryabov.cos4.service.UserService;
import com.innowise.ryabov.cos4.util.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .toList();
    }

    @Override
    public void saveUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users updateUser(Long id, UserRequest userRequest) {
        Users user = userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE + id)
                );
        user.setFirstname(userRequest.firstname());
        user.setLastname(userRequest.lastname());
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        val user = userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE)
                );
        userRepository.deleteById(user.getId());
    }

    @Override
    public UserDTO getUser(Long id) {
        return mapper.userToUserDTO(userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE)
                ));
    }

}
