package org.example.processing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPolynomial {
    private String stringPoly;
    final private ArrayList<String> tokens;
    public StringPolynomial(String string) {
        this.stringPoly = string;
        this.tokens = new ArrayList<>();
    }
    public Polynomial convertToPoly() {
        Polynomial p = new Polynomial(1000);
        try {
            this.tokenize();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        p.setMap(this.getPolyMapping());
        return p;
    }
    private void tokenize() throws Exception {
        for (Pattern pattern : Patterns.patterns2) {
            Matcher matcher = pattern.matcher(stringPoly);
            while (matcher.find()){
                tokens.add(matcher.group());
                stringPoly = stringPoly.replace(matcher.group(), "");
            }
        }
        if(!stringPoly.isEmpty())
        {
            tokens.clear();
            JFrame jFrame = new JFrame();
            jFrame.setLayout(new GridBagLayout());
            JLabel field = new JLabel("WRONG INPUT");
            jFrame.setPreferredSize(new Dimension(300,150));
            jFrame.setLocationRelativeTo(null);
            jFrame.add(field);
            jFrame.pack();
            jFrame.setVisible(true);
            throw new Exception("Input error");
        }
    }
    private Map<Integer, Double> getPolyMapping() {
        Map<Integer, Double> map = new HashMap<>();
        for (String token : tokens) {
            Pair<Integer, Integer> p;
            int sign = 1;
            Integer coefficient, degree;
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
                map.put(degree, sign * coefficient * 1.0);
                continue;
            }
            if(token.charAt(index) == '^') index++;
            p = this.convertToInteger(token, index);
            degree = p.getFirst();
            if(map.containsKey(degree))
                map.replace(degree, map.get(degree) + sign * coefficient * 1.0);
            else
                map.put(degree, sign * coefficient * 1.0);
        }
        return map;
    }
    private Pair<Integer, Integer> convertToInteger(String string, Integer index) {
        int answ = 1;
        if(string.charAt(index) >= '0' && string.charAt(index) <= '9'){
            answ = 0;
            do {
                answ = answ * 10 + (int)string.charAt(index) - (int)'0';
                index++;
            }while (string.charAt(index) >= '0' && string.charAt(index) <= '9');
        }
        return new Pair<>(answ, index);
    }
}
