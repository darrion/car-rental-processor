package com.example.carrentalprocessor.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class AppUser {

    @Id
    private Long id;
    private String username;
    private String name;
    private String password;
    private List<Permission> permission = new ArrayList<>();

    public boolean addPermission(Permission permission) {
        if (this.permission == null) {
            this.permission = new ArrayList<>();
        }
        return this.permission.add(permission);
    }

}
