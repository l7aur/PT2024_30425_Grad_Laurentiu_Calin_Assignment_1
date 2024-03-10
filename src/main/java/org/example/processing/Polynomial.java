package org.example.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Polynomial {
    private Map<Integer, Double> degreeToCoefficient;

    public Polynomial(Integer initialSize) {
        this.degreeToCoefficient = new HashMap<>(initialSize);
    }
    public Polynomial(ArrayList<Pair<Integer, Double>> arrayList) {
        this(1000);
        arrayList.forEach(x -> this.degreeToCoefficient.put(x.getFirst(), x.getSecond()));
    }
    public void setMap(Map<Integer, Double> map) {
        this.degreeToCoefficient = map;
    }
    public Map<Integer, Double> getMap() {
        return this.degreeToCoefficient;
    }
    public Polynomial add(Polynomial polynomial2) {
        Polynomial polynomial = new Polynomial(1000);
        polynomial.degreeToCoefficient.putAll(this.degreeToCoefficient);
        polynomial2.degreeToCoefficient.forEach((key, value) ->
        {
            Double oldValue = polynomial.degreeToCoefficient.get(key);
            if(oldValue == null) oldValue = 0.0;
            polynomial.degreeToCoefficient.put(key, oldValue + value);
            if(oldValue + value == 0)
                polynomial.degreeToCoefficient.remove(key);
        });
        if(polynomial.degreeToCoefficient.isEmpty())
            polynomial.degreeToCoefficient.put(0, 0.0);
        return polynomial;
    }
    public Polynomial subtract(Polynomial polynomial2) {
        Polynomial negatedPoly =  polynomial2.negate();
        return negatedPoly.add(this);

    }
    private Polynomial negate() {
        Polynomial polynomial = new Polynomial(1000);
        this.degreeToCoefficient.forEach((key, value) -> polynomial.degreeToCoefficient.put(key, -value));
        return polynomial;
    }
    public Polynomial multiply(Polynomial polynomial2) {
        Polynomial answer = new Polynomial(1000);
        this.degreeToCoefficient.forEach((x,y)->
                polynomial2.degreeToCoefficient.forEach((key, value) ->
                {
                    if(answer.degreeToCoefficient.containsKey(x + key)) {
                        Double oldVal = answer.degreeToCoefficient.get(x + key);
                        if(y * value + oldVal == 0)
                            answer.degreeToCoefficient.remove(x + key);
                        answer.degreeToCoefficient.replace(x + key, y * value + oldVal);
                    }
                    else if(y * value != 0)
                        answer.degreeToCoefficient.put(x + key, y * value);
                }));
        if(answer.degreeToCoefficient.isEmpty())
            answer.degreeToCoefficient.put(0,0.0);
        return answer;
    }
    public Polynomial multiplyByMonomial(Integer a, Double b) {
        Polynomial answer = new Polynomial(1000);
        this.degreeToCoefficient.forEach((x,y)-> {
                if(answer.degreeToCoefficient.containsKey(x + a)) {
                    Double oldVal = answer.degreeToCoefficient.get(x + a);
                    answer.degreeToCoefficient.replace(x + a, y * b + oldVal);
                }
                else
                    answer.degreeToCoefficient.put(x + a, y * b);
        });
        return answer;
    }
    public Polynomial divide(Polynomial polynomial2) {
        Polynomial result = new Polynomial(1000);
        Polynomial dummy = new Polynomial(1000);
        dummy.degreeToCoefficient = this.degreeToCoefficient;

        Integer maximumDeg1 = this.getMaximumDegree();
        Integer maximumDeg2 = polynomial2.getMaximumDegree();
        while (maximumDeg1 >= maximumDeg2 ) {
            if(maximumDeg2 == 0 && polynomial2.degreeToCoefficient.get(0) == 0){
                System.out.println("Can t divide by 0");
                break;
            }
            Integer mapDeg = maximumDeg1 - maximumDeg2;
            Double mapCoeff = dummy.degreeToCoefficient.get(maximumDeg1) / polynomial2.degreeToCoefficient.get(maximumDeg2);
            result.degreeToCoefficient.put(mapDeg, mapCoeff);

            dummy = dummy.subtract(polynomial2.multiplyByMonomial(mapDeg, mapCoeff));
            maximumDeg1 = dummy.getMaximumDegree();

        }
        System.out.print("Remainder: ");
        dummy.printPolynomial();
        if (result.degreeToCoefficient.isEmpty())
            result.degreeToCoefficient.put(0,0.0);
        return result;
    }
    private Integer getMaximumDegree() {
        final Integer[] answer = {0};
        this.degreeToCoefficient.forEach((x, y) ->
        {
            if(answer[0] < x && y != 0.0)
                answer[0] = x;
        });
        return answer[0];
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
            if(y > 0) {
                stringBuilder.append("+");
                stringBuilder.append(y);
                stringBuilder.append("*");
            }
            else if(y < 0) {
                stringBuilder.append(y);
                stringBuilder.append("*");
            }
            if(y != 0) {
                stringBuilder.append("X^");
                stringBuilder.append(x);
                stringBuilder.append(" ");
            }
            if(stringBuilder.isEmpty())
                stringBuilder.append("0");
        });
        return stringBuilder.toString();
    }
}
