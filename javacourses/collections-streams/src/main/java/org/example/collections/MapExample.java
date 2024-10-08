package org.example.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1"); // 19203
        map.put(2, "2"); // 10949
        map.put(3, "v"); // 10949

        System.out.println(map.get(1));

        Map<Integer, String> map2 = new TreeMap<>();

    }
}
