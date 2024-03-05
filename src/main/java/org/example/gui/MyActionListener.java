package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private OutputPanel outputPanel;
    private String newVal;
    public MyActionListener(OutputPanel outputPanel, String newVal){
        super();
        this.outputPanel = outputPanel;
        this.newVal = newVal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.outputPanel.refreshPanel(newVal);
    }
}
