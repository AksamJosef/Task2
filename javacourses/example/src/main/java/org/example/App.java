package org.example;

import org.example.entities.Repka;
import org.example.entities.Zhuchka;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        System.out.println("------------------------------------------------");
        Zhuchka zhuchka = applicationContext.getBean(Zhuchka.class);
        zhuchka.print();

        applicationContext.close();

    }
}
