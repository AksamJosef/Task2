package org.consumer.consumer_service.feign;

import org.consumer.consumer_service.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "example-client", url= "${feign.url}")
public interface FeignImpl {

    @GetMapping("/get-all")
    List<EmployeeDto> getAll();
}
