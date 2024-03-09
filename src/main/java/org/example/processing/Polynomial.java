package org.example.processing;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Polynomial {
    private Map<Integer, Double> degreeToCoefficient;

    public Polynomial(Integer initialSize) {
        this.degreeToCoefficient = new HashMap<>(initialSize);
    }
    public void readPolynomial(Map<Integer, Double> map) {
        this.degreeToCoefficient = map;
    }
    public Polynomial add(Polynomial polynomial2) {
        Polynomial polynomial = new Polynomial(1000);
        polynomial.degreeToCoefficient.putAll(this.degreeToCoefficient);
        polynomial2.degreeToCoefficient.forEach((key, value) ->
        {
            Double oldValue = polynomial.degreeToCoefficient.get(key);
            if(oldValue == null) oldValue = 0.0;
            polynomial.degreeToCoefficient.put(key, oldValue + value);
        });
//        polynomial.degreeToCoefficient.forEach((x,y) -> System.out.print(y + " * X^" + x + " "));
//        this.degreeToCoefficient.forEach((x,y) -> System.out.print(y + " * X^" + x + " "));
        return polynomial;
    }
    public Polynomial subtract(Polynomial polynomial2) {
        Polynomial negatedPoly =  polynomial2.negate();
        return negatedPoly.add(this);

    }
    public Polynomial negate() {
        this.degreeToCoefficient.forEach((key, value) -> this.degreeToCoefficient.put(key, -value));
        return this;
    }
    public Polynomial divide(Polynomial polynomial2) {
        //todo
        return null;
    }
    public Polynomial derivate() {
        Polynomial answPoly = new Polynomial(1000);
        this.degreeToCoefficient.forEach((key, value) ->
        {
            if(key > 0) {
                value *= key;
                key--;

                answPoly.degreeToCoefficient.put(key, value);
            }
            else
                answPoly.degreeToCoefficient.put(0,0.0);
        });
        return answPoly;
    }
    public Polynomial integrate() {
        Polynomial answPoly = new Polynomial(1000);
        this.degreeToCoefficient.forEach((key, value) ->
        {
            key++;
            value /= key;
            answPoly.degreeToCoefficient.put(key, value);
        });
        return answPoly;
    }
    public void printPolynomial() {
        AtomicBoolean printFlag = new AtomicBoolean(false);
        this.degreeToCoefficient.forEach((x,y) ->
        {
            if(y > 0) {
                System.out.print("+" + y);
                printFlag.set(true);
            }
            else if(y < 0) {
                System.out.print(y);
                printFlag.set(true);
            }
            if(y != 0) {
                if (x != 0) {
                    System.out.print(" X^" + x + " ");
                    printFlag.set(true);
                } else
                    System.out.print(" ");
            }
        });
        if(!printFlag.getAcquire())
            System.out.print("0");
        System.out.println();
    }
    public String polyToString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.degreeToCoefficient.forEach( (x, y) -> {
            if(y > 0)
                stringBuilder.append("+" + y + "*");
            else if(y < 0)
                    stringBuilder.append(y + "*");
            if(y != 0)
                    stringBuilder.append("X^" + x + " ");
            if(stringBuilder.isEmpty())
                stringBuilder.append("0");
        });
        return stringBuilder.toString();
    }
}
