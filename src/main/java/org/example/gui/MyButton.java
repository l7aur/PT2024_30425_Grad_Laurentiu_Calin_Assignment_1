package org.example.gui;

import javax.swing.*;

public class MyButton extends JButton {
    private final String operation;
    public MyButton(String string) {
        super(string);
        this.operation = string;
    }
    public String getOperation() {
        return operation;
    }
}
