package org.example.entities;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vnuchka {

    @PostConstruct
    private void init() {
        System.out.println("Внучка создана");
    }

    @Autowired
    private Babka babka;

    public void print() {
        System.out.println("Внучка за бабку");
        babka.print();
    }
}
