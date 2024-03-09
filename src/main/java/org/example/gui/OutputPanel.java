package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private JLabel outputText;
    public OutputPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300,100));
        this.outputText = new JLabel("RESULT");
    }

    public void setOutputText(JLabel outputText) {
        this.outputText = outputText;
    }

    public JLabel getOutputText() {
        return this.outputText;
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

    public void refreshPanel(String string) {
        this.outputText.setText("<html>" + string + "</html>"); //wrap the text
        this.repaint();
    }
    public void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
