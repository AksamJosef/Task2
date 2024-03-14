package org.dblesson;

import org.dblesson.entity.Cat;
import org.dblesson.service.CatService;
import org.dblesson.service.CatServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        processJDBCAtions();

        processHibernateAtions();
    }

    private static void processHibernateAtions() {
        CatService catService = new CatServiceImpl();

        catService.createTable();

//        catService.dropTable();

        Cat cat = Cat.builder()
                .name("Barsik")
                .owner("Nigmat")
                .color("Gray")
                .age(2)
                .build();

        Cat secondCat = Cat.builder()
                .name("Pushok")
                .owner("Nigmat")
                .color("White")
                .age(1)
                .build();

        catService.add(cat);
        catService.add(secondCat);

        catService.getAll().forEach(System.out::println);

        catService.deleteById(16L);

        catService.getAll().forEach(System.out::println);

    }

    private static void processJDBCAtions() {
        CatService catService = new CatServiceImpl();

        catService.createTable();

        Cat cat = Cat.builder()
                .name("Barsik")
                .owner("Nigmat")
                .color("Gray")
                .age(2)
                .build();

        Cat secondCat = Cat.builder()
                .name("Pushok")
                .owner("Nigmat")
                .color("White")
                .age(1)
                .build();

        catService.add(cat);
        catService.add(secondCat);

        List<Cat> cats = catService.getAll();

        System.out.println("BEFORE DELETE");
        cats.forEach(System.out::println);

        Long idForRemoval = cats.stream().findAny().map(Cat::getId).orElseThrow();

        catService.deleteById(idForRemoval);

        System.out.println("AFTER DELETE");
        catService.getAll().stream().forEach(System.out::println);

        catService.dropTable();
    }
}
