package org.consumer.consumer_service.controller;

import lombok.RequiredArgsConstructor;
import org.consumer.consumer_service.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public void test() {
        testService.print();
    }
}
