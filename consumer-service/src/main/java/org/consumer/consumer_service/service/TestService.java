package org.consumer.consumer_service.service;

import lombok.RequiredArgsConstructor;
import org.consumer.consumer_service.feign.FeignImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final FeignImpl feignImpl;

    public void print() {
        feignImpl.getAll().forEach(System.out::println);
    }
}
