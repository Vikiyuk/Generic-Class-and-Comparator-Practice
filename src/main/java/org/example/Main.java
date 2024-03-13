package org.example;

import java.util.*;

class Triple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>
        implements Comparator<Triple<T1, T2, T3>>, Comparable<Triple<T1,T2,T3>> {
    private T1 first;
    private T2 second;
    private T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public T3 getThird() {
        return third;
    }

    @Override
    public String toString() {
        return String.format("Triple<%s, %s, %s>", first, second, third);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) obj;
        return Objects.equals(first, triple.first) &&
                Objects.equals(second, triple.second) &&
                Objects.equals(third, triple.third);
    }

    @Override
    public int compareTo(Triple<T1, T2, T3> other) {
        int compareFirst = this.getFirst().compareTo(other.getFirst());
        if (compareFirst != 0)
            return compareFirst;

        int compareSecond = this.getSecond().compareTo(other.getSecond());
        if (compareSecond != 0)
            return compareSecond;

        return this.getThird().compareTo(other.getThird());
    }
    @Override
    public int compare(Triple<T1, T2, T3> triple1, Triple<T1, T2, T3> triple2) {
        int compareFirst = triple1.getFirst().compareTo(triple2.getFirst());
        if (compareFirst != 0)
            return -compareFirst; // Reversing the comparison

        int compareSecond = triple1.getSecond().compareTo(triple2.getSecond());
        if (compareSecond != 0)
            return -compareSecond; // Reversing the comparison

        return -triple1.getThird().compareTo(triple2.getThird());
    }
}

public class Main {
    public static void main(String[] args) {
        Triple<Integer, Float, Double> triple1 = new Triple<>(1, 2.5f, 3.0);
        System.out.println(triple1);
        Triple<Integer, Float, Double> triple2 = new Triple<>(1, 3f, 3.0);
        System.out.println("Equals? " + triple1.equals(triple2));
        List<Triple<Integer, Float, Double>> tripleList = new ArrayList<>();
        tripleList.add(new Triple<>(3, 3f, 5.0));
        tripleList.add(new Triple<>(3, 3f, 3.0));
        tripleList.add(new Triple<>(5, 2f, 7.0));
        tripleList.add(new Triple<>(2, 5f, 4.0));
        tripleList.add(new Triple<>(4, 6f, 6.0));
        Collections.sort(tripleList);
        System.out.println("Sorted List:");
        for (Triple<Integer, Float, Double> triple : tripleList) {
            System.out.println(triple);
        }
        Comparator<Triple<Integer, Float, Double>> Comparator = (t1, t2) -> t1.compare(t1,t2);
        tripleList.sort(Comparator);
        System.out.println("Comparator Sorted List:");
        for (Triple<Integer, Float, Double> triple : tripleList) {
            System.out.println(triple);
        }
    }
}
