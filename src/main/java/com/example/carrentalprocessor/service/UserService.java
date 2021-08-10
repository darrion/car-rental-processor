package com.example.carrentalprocessor.service;

import com.example.carrentalprocessor.repository.UserRepository;
import com.example.carrentalprocessor.table.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void addPermissionToUser(String username, String permissionName) {
        log.info("Adding permission {} to user {}", permissionName, username);
        User user = userRepository.findByUsername(username);
        user.setPermission(permissionName);
        userRepository.save(user);
    }

    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    public List<User> getUsers() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }
}
