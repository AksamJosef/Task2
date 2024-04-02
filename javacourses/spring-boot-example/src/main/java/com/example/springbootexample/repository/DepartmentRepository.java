package com.example.springbootexample.repository;

import com.example.springbootexample.entity.Department;
import com.example.springbootexample.enums.DepartmentKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(DepartmentKind name);
}
