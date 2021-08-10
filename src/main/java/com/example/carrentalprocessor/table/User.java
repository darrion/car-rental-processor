package com.example.carrentalprocessor.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@Table("users")
public class User {

    @Id
    private Long id;
    private String username;
    private String name;
    private String password;
    private String permission;

}
