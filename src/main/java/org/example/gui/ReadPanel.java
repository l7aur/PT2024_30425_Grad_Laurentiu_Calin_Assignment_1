package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class ReadPanel extends JPanel {
    private JTextField field1;
    private JTextField field2;
    public ReadPanel() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(300,100));
    }
    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 0;
        constraints.gridy = 0;
//        constraints.gridwidth = 1;
//        constraints.gridheight = 1;
        return constraints;
    }
    public void addTextFields() {
        this.field1 = new JTextField("Insert polynomial");
        this.field2 = new JTextField("Insert polynomial");

        this.add(Box.createVerticalGlue());
        this.add(field1);
        this.add(Box.createVerticalGlue());
        this.add(field2);
        this.add(Box.createVerticalGlue());
    }
}
