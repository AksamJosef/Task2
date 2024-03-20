package com.example.springbootexample.service;

import com.example.springbootexample.entity.Company;
import com.example.springbootexample.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company getById(UUID id) {
        return companyRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
