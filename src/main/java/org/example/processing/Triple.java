package org.example.processing;

public class Triple<T, G, H> {
    private T first;
    private G second;
    private H third;
    public Triple(T first, G second, H third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public H getThird() {
        return third;
    }

    public void setThird(H third) {
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public G getSecond() {
        return second;
    }

    public void setSecond(G second) {
        this.second = second;
    }
}
