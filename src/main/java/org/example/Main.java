package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Triple<Integer, Float, Double> triple1 = new Triple<>(1, 2.5f, 3.0);
        System.out.println(triple1);
        Triple<Integer, Float, Double> triple2 = new Triple<>(1, 3f, 3.0);
        System.out.println("Czy jest rowne? " + triple1.equals(triple2));
        List<Triple<Integer, Float, Double>> tripleList = new ArrayList<>();
        tripleList.add(new Triple<>(3, 3f, 5.0));
        tripleList.add(new Triple<>(3, 3f, 3.0));
        tripleList.add(new Triple<>(5, 2f, 7.0));
        tripleList.add(new Triple<>(2, 5f, 4.0));
        tripleList.add(new Triple<>(4, 6f, 6.0));
        Collections.sort(tripleList);
        System.out.println("Sortowana lista:");
        for (Triple<Integer, Float, Double> triple : tripleList) {
            System.out.println(triple);
        }
        Comparator<Triple<Integer, Float, Double>> Comparator = (t1, t2) -> t1.compare(t1,t2);
        tripleList.sort(Comparator);
        System.out.println("Lista sortowana za pomoca komparatora:");
        for (Triple<Integer, Float, Double> triple : tripleList) {
            System.out.println(triple);
        }
    }
}
