package com.example.carrentalprocessor.repository;

import com.example.carrentalprocessor.table.Cars;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CassandraRepository<Cars, String> {

}
