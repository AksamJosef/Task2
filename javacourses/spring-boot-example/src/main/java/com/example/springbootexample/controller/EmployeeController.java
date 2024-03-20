package com.example.springbootexample.controller;

import com.example.springbootexample.dto.EmployeeDto;
import com.example.springbootexample.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/add-default")
    public void createDefaultEmployee() {
        employeeService.addDefault();
    }


    @GetMapping("/get-all")
    public List<EmployeeDto> getAllEmployeesDto() {
        return employeeService.getAllEmployeesDto();
    }

    @PostMapping("/add-employee")
    public EmployeeDto addNewEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addNewEmployee(employeeDto);
    }

    @DeleteMapping("/delete-employee/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }
}
