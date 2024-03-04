package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JTextField field1;
    private JTextField field2;
    public InputPanel() {
        super();
        this.setBackground(Color.pink);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.field1 = new JTextField();
        this.field2 = new JTextField();
    }
    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        return constraints;
    }
    public void setPanelUI() {
        this.setPreferredSize(new Dimension(400,400));
        this.addVFiller();
        this.add(this.field1);
        this.addVFiller();
        this.add(this.field2);
    }
    private void addVFiller() {
        this.add(Box.createVerticalGlue());
    }
}
