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
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Validated
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(mapper::userToUserDTO)
                .toList();
    }

    @Override
    public void saveUser(UserRequest user) {
        userRepository.save(mapper.userRequestToUser(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserRequest userRequest) {
        Users user = findSafe(id);
        user.setFirstname(userRequest.firstname());
        user.setLastname(userRequest.lastname());
        user.setEmail(userRequest.email());
        user.setDrivingLicenseId(userRequest.drivingLicenseId());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setPassportId(userRequest.passportId());
        return mapper.userToUserDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        val user = findSafe(id);
        userRepository.deleteById(user.getId());
    }

    @Override
    public UserDTO getUser(Long id) {
        return mapper.userToUserDTO(findSafe(id));
    }

    private Users findSafe(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE)
                );
    }
}
