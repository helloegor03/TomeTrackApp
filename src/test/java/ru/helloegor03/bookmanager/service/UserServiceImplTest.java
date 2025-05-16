package ru.helloegor03.bookmanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.helloegor03.bookmanager.model.User;
import ru.helloegor03.bookmanager.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRegisterUser_successful() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("example1");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encoded password");
        when(userRepository.save(user)).thenReturn(user);

        User registeredUser = userService.registerUser(user);

        assertNotNull(registeredUser);
        assertEquals("test@example.com", registeredUser.getEmail());
        assertEquals("encoded password", registeredUser.getPassword());

        verify(userRepository).save(user);
    }
    @Test
    void testRegisterUser_failed(){
        User user = new User();
        user.setEmail("test2@example.com");
        user.setPassword("example2");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {userService.registerUser(user);});

        assertEquals("Пользователь с такой почтой уже существует", exception.getMessage());
    }



}
