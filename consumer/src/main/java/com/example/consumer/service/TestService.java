package com.example.consumer.service;

import com.example.consumer.feign.FeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final FeignRequest feignRequest;

    public void test() {
        feignRequest.getAll().forEach(System.out::println);
    }
}
