package org.example.entities;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Ded {

    @PostConstruct
    private void init() {
        System.out.println("Дед создан");
    }

    private final Repka repka;

    public Ded(Repka repka) {
        this.repka = repka;
    }


    public void print() {
        System.out.println("Дедка за репку");
        repka.print();
    }
}
