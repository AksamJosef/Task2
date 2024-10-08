package org.example2;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example2 {

    private static final List<Hotel> hotels = List.of(
            Hotel.builder()
                    .city("Omsk")
                    .address("OmskAddress")
                    .isOpened(true)
                    .build(),
            Hotel.builder()
                    .city("Omskiy rayon")
                    .address("OmskAddress2")
                    .isOpened(false)
                    .build(),
            Hotel.builder()
                    .city("Tomsk")
                    .address("TomskAddress")
                    .isOpened(true)
                    .build(),
            Hotel.builder()
                    .city("Moscow")
                    .address("Moscow")
                    .isOpened(false)
                    .build()
            );
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название города: ");
        String input = scanner.next();

        List<Hotel> filtered = hotels.stream() // Omsk ≠ omsk
                .filter(hotel -> hotel.getCity().toLowerCase().contains(input.toLowerCase()))
                .toList();

        filtered.forEach(System.out::println);
    }
}
