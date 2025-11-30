package com.anuragbansall.learnSpring.repositories;


import com.anuragbansall.learnSpring.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    // Long is the type of the primary key and EmployeeEntity is the entity type
    // JpaRepository provides basic CRUD operations out of the box

    List<EmployeeEntity> findByName(String name); // Custom query method to find employees by name - automatically implemented by Spring Data JPA
}