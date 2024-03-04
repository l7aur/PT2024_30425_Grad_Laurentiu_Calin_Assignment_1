package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class CalcPane extends JPanel {
    public CalcPane() {
        super();
        this.setName("Polynomial Calculator");
        this.setBackground(Color.green);
    }
    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 5;
        return constraints;
    }
    public void setPaneUI() {
        this.setPreferredSize(new Dimension(600, 400));
    }
}
