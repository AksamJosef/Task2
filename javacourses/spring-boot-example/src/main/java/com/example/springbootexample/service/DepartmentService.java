package com.example.springbootexample.service;

import com.example.springbootexample.entity.Department;
import com.example.springbootexample.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department getById(UUID id) {
        return departmentRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
