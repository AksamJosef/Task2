package org.example.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");

        Iterator<String> setIterator = set.iterator();

        int counter = 0;
        String el = null;

        while (setIterator.hasNext()) {
             el = setIterator.next();

            if ("three".equals(el)) break;
        }

        System.out.println(el);
    }
}
