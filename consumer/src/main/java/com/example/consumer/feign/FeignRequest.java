package com.example.consumer.feign;

import com.example.consumer.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "example-client", url= "http://localhost:8080/employee")
public interface FeignRequest {

    @GetMapping("/get-all")
    List<EmployeeDto> getAll();
}
