package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final Container mainPane;
    public MainFrame() {
        super();
        this.mainPane =this.getContentPane();
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

    }
}
