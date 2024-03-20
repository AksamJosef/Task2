package com.example.springbootexample.service;

import com.example.springbootexample.dto.CompanyDto;
import com.example.springbootexample.dto.DepartmentDto;
import com.example.springbootexample.dto.EmployeeDto;
import com.example.springbootexample.entity.Company;
import com.example.springbootexample.entity.Department;
import com.example.springbootexample.entity.Employee;
import com.example.springbootexample.enums.Citizenship;
import com.example.springbootexample.enums.DepartmentKind;
import com.example.springbootexample.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CompanyService companyService;

    private final DepartmentService departmentService;

    public void addDefault() {
        Company company = Company.builder()
                .name("OOO BEST IT")
                .build();

        Department department = Department.builder()
                .name(DepartmentKind.IT)
                .company(company)
                .build();

        Employee employee = Employee.builder()
                .citizenship(Citizenship.RU)
                .name("Nigmat")
                .lastName("Nigmatullin")
                .employmentDate(LocalDate.of(2023, 9, 14))
                .salary(410_000)
                .department(department)
                .build();

        Employee savedEntity = employeeRepository.save(employee);

        System.out.println("Успешно сохранена сущность " + savedEntity);
    }

    public List<EmployeeDto> getAllEmployeesDto() {
        return employeeRepository.findAll().stream()
                .map(employee -> transformToDto(employee))
                .collect(Collectors.toList());
    }

    private EmployeeDto transformToDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .salary(employee.getSalary())
                .employmentDate(employee.getEmploymentDate())
                .citizenship(employee.getCitizenship())
                .department(transformToDto(employee.getDepartment()))
                .build();
    }

    private DepartmentDto transformToDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .company(CompanyDto.builder()
                        .id(department.getCompany().getId())
                        .name(department.getCompany().getName())
                        .build())
                .build();
    }

    @Transactional
    public EmployeeDto addNewEmployee(EmployeeDto employeeDto) {
        CompanyDto companyDto = employeeDto.getDepartment().getCompany();

        Company company = Company.builder()
                .id(companyDto.getId())
                .name(companyDto.getName())
                .build();

        DepartmentDto departmentDto = employeeDto.getDepartment();

        Department department = Department.builder()
                .id(departmentDto.getId())
                .name(departmentDto.getName())
                .company(company)
                .build();

//        Company company = companyService.getById(employeeDto.getDepartment().getCompany().getId());
//
//        Department department = departmentService.getById(employeeDto.getDepartment().getId());
//        department.setCompany(company);

        Employee employee = Employee.builder()
                .name(employeeDto.getName())
                .lastName(employeeDto.getLastName())
                .salary(employeeDto.getSalary())
                .citizenship(employeeDto.getCitizenship())
                .employmentDate(employeeDto.getEmploymentDate())
                .department(department)
                .build();

        Employee savedEntity = employeeRepository.save(employee);

        return transformToDto(savedEntity);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
