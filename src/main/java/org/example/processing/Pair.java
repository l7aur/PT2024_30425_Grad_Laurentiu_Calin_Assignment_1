package org.example.processing;

public class Pair<T, G> {
    private T first;
    private G second;

    public Pair(T first, G second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }

    public G getSecond() {
        return second;
    }

}
