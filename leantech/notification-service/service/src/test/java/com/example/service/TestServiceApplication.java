package com.example.service;

import org.springframework.boot.SpringApplication;

public class TestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(ServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
