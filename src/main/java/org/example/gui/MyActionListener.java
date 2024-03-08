package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private final OutputPanel outputPanel;
    private String newVal;
    private String operation;
    public MyActionListener(OutputPanel outputPanel, String operation){
        super();
        this.outputPanel = outputPanel;
        this.operation = operation;
        this.newVal = "";
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button pressed");
//        this.outputPanel.refreshPanel(this.performCalc("11", "32"));
        this.setNewVal("aaaa");
//        this.outputPanel.repaint();
        this.outputPanel.refreshPanel(newVal);
    }
    public String performCalc(String number1, String number2) {
        return "aaaaaaaa";
    }
}
