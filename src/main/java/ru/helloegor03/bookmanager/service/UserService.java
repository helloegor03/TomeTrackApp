package ru.helloegor03.bookmanager.service;

import ru.helloegor03.bookmanager.model.User;
import ru.helloegor03.bookmanager.repository.UserRepository;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();


}
