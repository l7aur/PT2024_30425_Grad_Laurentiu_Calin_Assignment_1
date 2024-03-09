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
        this.outputPanel.refreshPanel(this.performCalc());
    }
    private Pair<StringPolynomial,StringPolynomial> getInputPolys() {
        Pair<StringPolynomial, StringPolynomial> answer = new Pair<>();
        StringPolynomial p1 = new StringPolynomial(this.readPanel.getField1().getText());
        StringPolynomial p2 = new StringPolynomial(this.readPanel.getField2().getText());

        return answer;
    }
    public Polynomial performCalc(Polynomial p1, Polynomial p2) {

        return null;
    }
}
