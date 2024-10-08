package org.example.collections;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int b = scanner.nextInt();

        int c = scanner.nextInt();

        int result = a * 100 + b * 10 + c;

        System.out.println(result);


    }
}
