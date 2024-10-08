package org.example.entities;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Babka {

    private final Ded ded;

    @PostConstruct
    private void init() {
        System.out.println("Бабка создана");
    }

    public void print() {
        System.out.println("Бабка за дедку");
        ded.print();
    }
}
