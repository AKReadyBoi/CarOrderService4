package com.innowise.ryabov.cos4.service.serviceImplementation;
import com.innowise.ryabov.cos4.dto.UserDTO;
import com.innowise.ryabov.cos4.entity.Users;
import com.innowise.ryabov.cos4.mapper.UserMapper;
import com.innowise.ryabov.cos4.repository.UserRepository;
import com.innowise.ryabov.cos4.request.UserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
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

    @Test
    void saveUser() {
        String test = "test";
        Users user = new Users();
        user.setFirstname(test);
        userService.saveUser(user);
        verify(userRepository, times(1)).save(any(Users.class));
    }

    @Test
    void updateUser() {
        Long userId = 1L;
        String test = "test";
        UserRequest userRequest = mock(UserRequest.class);
        when(userRequest.firstname()).thenReturn(test);
        when(userRequest.lastname()).thenReturn(test);
        Users user = new Users();
        user.setFirstname("first");
        user.setLastname("fast");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Users updatedUser = userService.updateUser(userId, userRequest);
        verify(userRepository, times(1)).findById(userId);
        assertEquals(test, updatedUser.getFirstname());
        assertEquals(test, updatedUser.getLastname());
    }

    @Test
    void deleteUser() {
        Long userId = 1L;
        userService.deleteUser(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }
}