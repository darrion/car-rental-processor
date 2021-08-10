package com.example.carrentalprocessor.repository;

import com.example.carrentalprocessor.table.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, Long> {

    @AllowFiltering
    public User findByUsername(String username);
}
