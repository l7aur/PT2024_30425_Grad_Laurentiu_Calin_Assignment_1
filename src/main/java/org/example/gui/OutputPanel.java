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
        for (Component component : this.getComponents()) {
            if(component instanceof JLabel)
                this.remove(component);
        }
//        this.outputText = new JLabel(string);
        this.outputText = new JLabel("masina");
        this.outputText.setPreferredSize(new Dimension(100,40));
        this.outputText.setBackground(Color.black);
        this.addVFiller();
        this.add(this.outputText);
        this.addVFiller();
        this.repaint();
        System.out.println("refreshed panel");
    }
    public void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
