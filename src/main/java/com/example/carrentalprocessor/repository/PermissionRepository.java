package com.example.carrentalprocessor.repository;

import com.example.carrentalprocessor.table.Permission;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends CassandraRepository<Permission, Long> {

    @AllowFiltering
    public Permission findByName(String name);
}
