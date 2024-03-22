package org.example.gui;

import org.example.processing.Pair;
import org.example.processing.Polynomial;
import org.example.processing.StringPolynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private final OutputPanel outputPanel;
    private final ReadPanel readPanel;
    private final String operation;
    public MyActionListener(ReadPanel readPanel, OutputPanel outputPanel, String operation){
        super();
        this.readPanel = readPanel;
        this.outputPanel = outputPanel;
        this.operation = operation;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Pair<Polynomial, Polynomial> answer = this.performCalc();
        this.outputPanel.refreshPanel(answer);
    }
    private Polynomial getInputPoly(JTextField textField) {
        StringPolynomial stringPolynomial = new StringPolynomial(textField.getText());
        return stringPolynomial.convertToPoly();
    }
    public Pair<Polynomial, Polynomial> performCalc() {
        Pair<Polynomial, Polynomial> answer = new Pair<>();
        answer.setSecond(null);
        Polynomial polynomial1, polynomial2;
        switch (this.operation) {
            case "Addition":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer.setFirst(polynomial1.add(polynomial2));
                break;
            case "Subtraction":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer.setFirst(polynomial1.subtract(polynomial2));
                break;
            case "Multiplication":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer.setFirst(polynomial1.multiply(polynomial2));
                break;
            case "Division":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer.setFirst(polynomial1.divide(polynomial2).getFirst());
                answer.setSecond(polynomial1.divide(polynomial2).getSecond());
                break;
            case "Derivation":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                answer.setFirst(polynomial1.derivate());
                break;
            case "Integration":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                answer.setFirst(polynomial1.integrate());
                break;
            default:
                System.out.println("You should not be able to get here");
                break;
        }
        return answer;
    }
}
