package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel() {
        super();
        this.setBackground(Color.black);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        return constraints;
    }

    public void setPaneUI(){
        this.setPreferredSize(new Dimension(400,400));
        this.addVFiller();
        this.addVFiller();
    }
    private void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
