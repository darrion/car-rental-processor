package com.example.carrentalprocessor.repository;

import com.example.carrentalprocessor.table.AppUser;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends CassandraRepository<AppUser, Long> {

    @AllowFiltering
    public AppUser findByUsername(String username);
}
