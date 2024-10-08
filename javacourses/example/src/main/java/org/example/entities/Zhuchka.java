package org.example.entities;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zhuchka {

    @PostConstruct
    private void init() {
        System.out.println("Жучка создана");
    }

    private Vnuchka vnuchka;

    @Autowired
    public void setVnuchka(Vnuchka vnuchka) {
        this.vnuchka = vnuchka;
    }

    public void print() {
        System.out.println("Жука за внучку");
        vnuchka.print();
    }
}
