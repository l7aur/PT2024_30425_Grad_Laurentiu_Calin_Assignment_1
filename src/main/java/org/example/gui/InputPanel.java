package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {
    private final OutputPanel outputPanel;
    private final ReadPanel readPanel;
    public InputPanel() {
        super();
        this.setBackground(Color.pink);
        this.setLayout(new GridBagLayout());
        this.outputPanel = new OutputPanel();
        this.readPanel = new ReadPanel();
    }

    public OutputPanel getOutputPanel() {
        return outputPanel;
    }

    public ReadPanel getReadPanel() {
        return readPanel;
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
        this.readPanel.addTextFields();
        this.add(this.readPanel, this.readPanel.getConstraints(insets));
        this.outputPanel.setPaneUI();
        this.add(this.outputPanel, this.outputPanel.getConstraints(insets));
    }
}
