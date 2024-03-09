package org.example.processing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPolynomial {
    private String stringPoly;
    final private ArrayList<String> tokens;

    public StringPolynomial() {
        this.stringPoly = "";
        this.tokens = new ArrayList<>();
    }
    public StringPolynomial(String string) {
        this.stringPoly = string;
        this.tokens = new ArrayList<>();
    }

    public String getStringPoly() {
        return stringPoly;
    }

    public void read(String string) {
        this.stringPoly = string;
    }

    public Polynomial convertToPoly() {
        Polynomial p = new Polynomial(1000);
        this.tokenize();
        p.readPolynomial(this.getPolyMapping());
        p.printPolynomial();
        return p;
    }
    private void tokenize() {
        for (Pattern pattern : Patterns.patterns) {
            Matcher matcher = pattern.matcher(stringPoly);
            while (matcher.find()){
                tokens.add(matcher.group());
                stringPoly = stringPoly.replace(matcher.group(), "");
            }
        }
        if(!stringPoly.isEmpty())
            System.out.println("please check");
    }

    private Map<Integer, Integer> getPolyMapping() {
        Map<Integer, Integer> map = new HashMap<>();
        for (String token : tokens) {
//            System.out.println("preprocess: " + token);
            Pair<Integer, Integer> p;
            Integer sign = 1;
            Integer coefficient = 1;
            Integer degree = 1;
            Integer index = 0;
            token += ' ';
            if(token.charAt(index) == '-'){
                sign = -1;
                index++;
            }
            if(token.charAt(index) == '+') index++;
            p = this.convertToInteger(token, index);
            coefficient = p.getFirst();
            index = p.getSecond();
            if(token.charAt(index) == '*') index++;
            if(token.charAt(index) == 'X') index++;
            else {
                degree = 0;
//                System.out.println("postprocess: " + degree + " " + sign * coefficient);
                map.put(degree, sign * coefficient);
                continue;
            }
            if(token.charAt(index) == '^') index++;
            p = this.convertToInteger(token, index);
            degree = p.getFirst();
            index = p.getSecond();
//            System.out.println("postprocess: " + degree + " " + coefficient);
            map.put(degree, sign * coefficient);
        }
//        map.forEach((x,y)-> System.out.println(x + " " + y));
        return map;
    }
    private Pair<Integer, Integer> convertToInteger(String string, Integer index) {
        Integer answ = 1;
        if(string.charAt(index) >= '0' && string.charAt(index) <= '9'){
            answ = 0;
            do {
                answ = answ * 10 + (int)string.charAt(index) - (int)'0';
                index++;
            }while (string.charAt(index) >= '0' && string.charAt(index) <= '9');
        }
        return new Pair<Integer, Integer>(answ, index);
    }
    public void print(){
        System.out.println(stringPoly);
    }
}
