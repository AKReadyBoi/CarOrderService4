package com.innowise.ryabov.cos4.service.impl;
import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.mapper.UserMapper;
import com.innowise.ryabov.cos4.repository.UserRepository;
import com.innowise.ryabov.cos4.request.UserRequest;
import com.innowise.ryabov.cos4.util.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private static final String LAST = "last";
    private static final String TEST = "test";
    private static final String FIRST = "first";
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper mapper;
    @InjectMocks
    private UserServiceImpl userService;
    @Test
    void getAllUsers() {
        List<Users> users = new ArrayList<>();
        users.add(new Users());

        when(userRepository.findAll()).thenReturn(users);
        when(mapper.userToUserDTO(new Users())).thenReturn(new UserDTO());

        List<UserDTO> userDTOS = userService.getAllUsers();

        assertNotNull(userDTOS);
        assertEquals(1, userDTOS.size());
    }

//    @Test
//    void saveUser() {
//        Users user = new Users();
//
//        userService.saveUser(user);
//
//        verify(userRepository, times(1)).save(any(Users.class));
//    }
//    @Test
//        void updateUser_ThrowsUserNotFoundException() {
//            Long id = 1L;
//            UserRequest request = new UserRequest(FIRST, LAST);
//
//            when(userRepository.findById(id)).thenReturn(Optional.empty());
//
//            assertThrows(UserNotFoundException.class, () -> userService.updateUser(id,request));
//        }
        @Test
        void deleteUser_ThrowsUserNotFoundException() {
            Long id = 1L;

            when(userRepository.findById(id)).thenReturn(Optional.empty());

            assertThrows(UserNotFoundException.class, () -> userService.deleteUser(id));
    }

//    @Test
//    void updateUser() {
//        Long userId = 1L;
//        Users user = new Users();
//        user.setFirstname(FIRST);
//        user.setLastname(LAST);
//        UserRequest userRequest = new UserRequest(TEST, TEST);
//
//        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//        Users updatedUser = userService.updateUser(userId, userRequest);
//
//        verify(userRepository, times(1)).findById(userId);
//        assertEquals(TEST, updatedUser.getFirstname());
//        assertEquals(TEST, updatedUser.getLastname());
//    }

    @Test
    void deleteUser() {
        Long userId = 1L;
        Users users = new Users();
        users.setId(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(users));

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void getUser() {
        Long userId = 1L;
        Users users = new Users();
        users.setId(userId);
        users.setFirstname(TEST);
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(TEST);

        when(userRepository.findById(userId)).thenReturn(Optional.of(users));
        when(mapper.userToUserDTO(users)).thenReturn(userDTO);

        UserDTO userDto = userService.getUser(userId);

        assertNotNull(userDto);
        assertEquals(userDto.getFirstname(), users.getFirstname());
        verify(userRepository, times(1)).findById(userId);
    }
    @Test
    void getUser_UserNotFound_ThrowsUserNotFoundException() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUser(userId));
    }
}