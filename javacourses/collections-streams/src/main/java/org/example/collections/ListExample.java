package org.example.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListExample {

    public static void main(String[] args) {
        long beforeArray = System.currentTimeMillis();
        ArrayList<String> arrayList = initArrayList();
        System.out.println("Array List Time INIT:" + (System.currentTimeMillis() - beforeArray));

        long beforeLinked = System.currentTimeMillis();
        LinkedList<String> linkedList = initLinkedList();
        System.out.println("Linked List Time INIT:" + (System.currentTimeMillis() - beforeLinked));


//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        long beforeArrayInsert = System.currentTimeMillis();
//        insertArrayList(arrayList);
//        System.out.println("Array List Time INSERT:" + (System.currentTimeMillis() - beforeArrayInsert));
//
//        long beforeLinkedInsert = System.currentTimeMillis();
//        insertLinkedList(linkedList);
//        System.out.println("Linked List Time INSERT:" + (System.currentTimeMillis() - beforeLinkedInsert));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        long beforeArrayFind = System.currentTimeMillis();
        arrayList.get(25_000_000);
        System.out.println("Array List Time FIND:" + (System.currentTimeMillis() - beforeArrayFind));

        long beforeLinkedFind = System.currentTimeMillis();
        linkedList.get(25_000_000);
        System.out.println("Linked List Time FIND:" + (System.currentTimeMillis() - beforeLinkedFind));
    }

    private static void insertLinkedList(LinkedList<String> linkedList) {
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add(100, String.valueOf(i));
        }
    }

    private static void insertArrayList(ArrayList<String> arrayList) {
        for (int i = 0; i < 10_000; i++) {
            arrayList.add(100, String.valueOf(i));
        }
    }

    private static LinkedList<String> initLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 30_000_000; i++) {
            linkedList.add(String.valueOf(i));
        }

        return linkedList;
    }

    private static ArrayList<String> initArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 30_000_000; i++) {
            arrayList.add(String.valueOf(i));
        }

        return arrayList;
    }

}
