package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Repka {

    @PostConstruct
    private void init() {
        System.out.println("Репка создана");
    }

    @PreDestroy
    private void close() {
        System.out.println("Репка вытянута");
    }
}
