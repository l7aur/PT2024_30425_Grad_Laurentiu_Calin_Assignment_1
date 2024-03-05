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
        this.outputText = new JLabel(string);
        this.outputText.setPreferredSize(new Dimension(350,40));
        this.addVFiller();
        this.add(this.outputText);
        this.addVFiller();
    }
    private void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
