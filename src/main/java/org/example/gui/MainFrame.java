package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Container mainPane;
    public MainFrame() {
        super();
        this.mainPane = this.getContentPane();
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.mainPane.setLayout(new GridBagLayout());
        this.mainPane.setBackground(Color.darkGray);
    }
    public void makePublic() {
        this.setMinimumSize(new Dimension(1000,600));
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setPaneUI() {
        Insets insets = new Insets(5,5,5,5);
        InputPanel inputPanel = new InputPanel();
        CalcPanel calcPanel = new CalcPanel();

        GridBagConstraints iPanelConstraints = inputPanel.getConstraints(insets);
        GridBagConstraints cPanelConstraints = calcPanel.getConstraints(insets);

        inputPanel.setPanelUI();
        calcPanel.setPaneUI();

        mainPane.add(inputPanel, iPanelConstraints);
        mainPane.add(calcPanel, cPanelConstraints);
    }
}
