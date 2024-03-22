package org.example.gui;

import org.example.processing.Pair;
import org.example.processing.Polynomial;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private final JLabel outputText;
    public OutputPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300,100));
        this.outputText = new JLabel("RESULT");
    }
    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 0;
        constraints.gridy = 1;
        return constraints;
    }

    public void setPaneUI(){
        this.setPreferredSize(new Dimension(300,100));
        this.addVFiller();
        this.add(outputText);
        this.addVFiller();
    }

    public void refreshPanel(Pair<Polynomial, Polynomial> pair) {
        StringBuilder string = new StringBuilder();
        string.append(pair.getFirst().toString());
        if(pair.getSecond() != null) {
            string.append("|");
            string.append(pair.getSecond().toString());
        }
        this.outputText.setText("<html>" + string + "</html>"); //wrap the text
        this.repaint();
    }
    public void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
