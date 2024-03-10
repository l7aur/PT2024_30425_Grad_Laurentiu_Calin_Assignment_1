package org.example.gui;

import org.example.processing.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CalcPanel extends JPanel {
    private final InputPanel inputPanel;
    public CalcPanel(InputPanel inputPanel) {
        super();
        this.inputPanel = inputPanel;
        this.setName("Polynomial Calculator");
        this.setPreferredSize(new Dimension(400, 400));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.orange);
    }
    public GridBagConstraints getConstraints(Insets insets) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = insets;
        constraints.gridx = 1;
        constraints.gridy = 0;
        return constraints;
    }
    public void setPaneUI() {
        this.addButtons();
    }
    public void addButtons() {
        Insets insets = new Insets(5,5,5,5);
        ArrayList<String> buttonNames = this.getNames();
        ArrayList<Pair<Integer, Integer>> pos = this.getPositions();
        for (int index = 0; index < buttonNames.size(); index++) {
            MyButton b = new MyButton(buttonNames.get(index));
            b.addActionListener(new MyActionListener(this.inputPanel.getReadPanel(), this.inputPanel.getOutputPanel(), b.getOperation()));
            this.add(b, getButtonConstraints(insets, pos.get(index).getFirst(), pos.get(index).getSecond()));
        }
    }
    public ArrayList<Pair<Integer, Integer>> getPositions() {
        ArrayList<Pair<Integer, Integer>> pos = new ArrayList<>();
        pos.add(new Pair<>(0,0));
        pos.add(new Pair<>(1,0));
        pos.add(new Pair<>(0,1));
        pos.add(new Pair<>(1,1));
        pos.add(new Pair<>(1,2));
        pos.add(new Pair<>(0,2));
        return pos;
    }
    public ArrayList<String> getNames() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Addition");
        arrayList.add("Subtraction");
        arrayList.add("Multiplication");
        arrayList.add("Division");
        arrayList.add("Derivation");
        arrayList.add("Integration");
        return arrayList;
    }
    public GridBagConstraints getButtonConstraints(Insets insets, Integer posX, Integer posY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.insets = insets;
        constraints.weightx = 2;
        constraints.weighty = 1;
        return constraints;
    }
}