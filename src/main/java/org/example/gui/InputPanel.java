package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private JLabel label;
    public InputPanel() {
        super();
        this.setBackground(Color.pink);
        this.setLayout(new GridBagLayout());
        this.label = new JLabel("dasda");
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
        Insets insets = new Insets(5,5,5,5);
        ReadPanel rPanel = new ReadPanel();
        rPanel.addTextFields();
        this.add(rPanel, rPanel.getConstraints(insets));

        OutputPanel outputPanel = new OutputPanel();
        outputPanel.setPaneUI();
        this.add(outputPanel, outputPanel.getConstraints(insets));


    }

}
