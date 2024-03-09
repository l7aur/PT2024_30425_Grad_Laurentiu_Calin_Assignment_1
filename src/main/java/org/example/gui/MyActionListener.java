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
        Polynomial answer = this.performCalc();
        this.outputPanel.refreshPanel(answer.polyToString());
    }

    private Polynomial getInputPoly(JTextField textField) {
        StringPolynomial stringPolynomial = new StringPolynomial(textField.getText());
        return stringPolynomial.convertToPoly();
    }

    public Polynomial performCalc() {
        Polynomial answer = new Polynomial(1000);
        Polynomial polynomial1, polynomial2;
        switch (this.operation) {
            case "Addition":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer = polynomial1.add(polynomial2);
                break;
            case "Subtraction":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer = polynomial1.subtract(polynomial2);
                break;
            case "Multiplication":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer = polynomial1.multiply(polynomial2);
                break;
            case "Divide":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                polynomial2 = this.getInputPoly(this.readPanel.getField2());
                answer = polynomial1.divide(polynomial2);
                break;
            case "Derivation":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                answer = polynomial1.derivate();
                break;
            case "Integration":
                polynomial1 = this.getInputPoly(this.readPanel.getField1());
                answer = polynomial1.integrate();
                break;
            default:
                System.out.println("You should not be able to get here");
                break;
        }
        return answer;
    }
}
