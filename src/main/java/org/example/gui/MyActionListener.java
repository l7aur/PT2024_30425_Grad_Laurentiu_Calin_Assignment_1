package org.example.gui;

import org.example.processing.Pair;
import org.example.processing.Polynomial;
import org.example.processing.StringPolynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private final OutputPanel outputPanel;
    private final ReadPanel readPanel;
    private String newVal;
    private String operation;
    public MyActionListener(ReadPanel readPanel, OutputPanel outputPanel, String operation){
        super();
        this.readPanel = readPanel;
        this.outputPanel = outputPanel;
        this.operation = operation;
        this.newVal = "test";
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed");
        Pair<StringPolynomial, StringPolynomial> inputPolys = this.getInputPolys();
        this.outputPanel.refreshPanel(this.performCalc(inputPolys.getFirst().convertToPoly(),
                                                        inputPolys.getSecond().convertToPoly()).polyToString());
    }
    private Pair<StringPolynomial,StringPolynomial> getInputPolys() {
        Pair<StringPolynomial, StringPolynomial> answer = new Pair<>();
        StringPolynomial p1 = new StringPolynomial(this.readPanel.getField1().getText());
        StringPolynomial p2 = new StringPolynomial(this.readPanel.getField2().getText());
        System.out.println(p1.getStringPoly() + " " + p2.getStringPoly());
        answer.setFirst(p1);
        answer.setSecond(p2);
        return answer;
    }
    public Polynomial performCalc(Polynomial p1, Polynomial p2) {
        Polynomial answer = new Polynomial(1000);
        switch (this.operation){
            case "Addition":
                answer = p1.add(p2);
                break;
            case "Subtraction":
                answer = p1.subtract(p2);
                break;
            case "Derivation":
                answer = p1.derivate();
                break;
            case "Integration":
                answer = p1.integrate();
                break;
            case "Multiply":
                break;
            case "Divide":
                break;
            default:
                System.out.println("default case");
                break;
        }
        return answer;
    }
}
