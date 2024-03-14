package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Triple<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>
        implements Comparator<Triple<T1, T2, T3>>, Comparable<Triple<T1, T2, T3>> {
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
            return -compareFirst;
        int compareSecond = triple1.getSecond().compareTo(triple2.getSecond());
        if (compareSecond != 0)
            return -compareSecond;
        return -triple1.getThird().compareTo(triple2.getThird());
    }
}
