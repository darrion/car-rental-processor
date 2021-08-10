package com.example.carrentalprocessor.controller;

import com.example.carrentalprocessor.service.UserService;
import com.example.carrentalprocessor.table.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUsers(@RequestBody User user) {
        URI uri = URI.create(String.valueOf(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save")));
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/permission/add")
    public ResponseEntity<String> addPermission(@RequestBody PermissionToUserForm form) {
        userService.addPermissionToUser(
                form.getUsername(),
                form.getPermissionName()
        );
        return ResponseEntity.ok().build();
    }

    @Data
    class PermissionToUserForm {
        private String username;
        private String permissionName;
    }
}
