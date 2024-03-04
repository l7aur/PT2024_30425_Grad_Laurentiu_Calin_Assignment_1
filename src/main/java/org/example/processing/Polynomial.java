package org.example.processing;

import jdk.jshell.EvalException;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer, Integer> degreeToCoefficient;

    public Polynomial(Integer initialSize) {
        this.degreeToCoefficient = new HashMap<>(initialSize);
    }
    public void readPolynomial(Map<Integer, Integer> map) {
        this.degreeToCoefficient = map;
    }
    public Polynomial add(Polynomial polynomial2) {
        Polynomial polynomial = new Polynomial(1000);
        polynomial.degreeToCoefficient.putAll(this.degreeToCoefficient);
        polynomial2.degreeToCoefficient.forEach((key, value) ->
                polynomial.degreeToCoefficient.replace(key, polynomial.degreeToCoefficient.get(key) + value));
        return polynomial;
    }
    public Polynomial substract(Polynomial polynomial2) {
        Polynomial negatedPoly =  this.negate();
        return negatedPoly.add(polynomial2);

    }
    public Polynomial negate() {
        this.degreeToCoefficient.forEach((key, value) -> this.degreeToCoefficient.put(key, -value));
        return this;
    }
    public Polynomial divide(Polynomial polynomial2) {

        return null;
    }
    public Polynomial derivate() {

        return null;
    }
    public Polynomial integrate() {

        return null;
    }
    public void printPolynomial() {
        degreeToCoefficient.forEach((x,y)-> System.out.println("Degree " + x + " --> " + y));
    }
}
