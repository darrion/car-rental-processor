package com.example.carrentalprocessor.service;

import com.example.carrentalprocessor.repository.PermissionRepository;
import com.example.carrentalprocessor.repository.UserRepository;
import com.example.carrentalprocessor.table.AppUser;
import com.example.carrentalprocessor.table.Permission;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser saveUser(AppUser appUser) {
        String password = appUser.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        appUser.setPassword(encodedPassword);
        return userRepository.save(appUser);
    }

    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void addPermissionToUser(String username, String permissionName) {
        log.info("Adding permission {} to user {}", permissionName, username);
        AppUser appUser = userRepository.findByUsername(username);
        Permission permission = permissionRepository.findByName(permissionName);
        appUser.addPermission(permission);
        userRepository.save(appUser);
    }

    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    public List<AppUser> getUsers() {
        log.info("Fetching all users.");
        return userRepository.findAll();
    }
}
