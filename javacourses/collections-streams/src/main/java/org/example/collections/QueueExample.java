package org.example.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

//        FIFO -- FIRST IN FIRST OUT
//        LIFO  -- LAST IN FIRST OUT

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("third");
        deque.addFirst("second");
        deque.addFirst("first");

        deque.addLast("fourth");

//        deque.stream().forEach(System.out::println);

        System.out.println(deque.getLast());
        System.out.println(deque.getFirst());

//        ()()()((()))()(()) ||||     ))))((((


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println(checkSkobochki("()()()((()))()(()"));
    }

    private static boolean checkSkobochki(String s) {
        Deque<Character> skobki = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                skobki.addLast(s.charAt(i));
            } else if (s.charAt(i) == ')') skobki.removeLast();
        }

        return skobki.isEmpty();
    }
}
