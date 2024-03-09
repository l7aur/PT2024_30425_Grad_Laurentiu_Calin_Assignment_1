package org.example;

import org.example.gui.MainFrame;
import org.example.processing.Polynomial;
import org.example.processing.StringPolynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public App() {

    }
    public void startApp() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setPaneUI();
        mainFrame.makePublic();

    }
    public void quitApp() {

    }
}
