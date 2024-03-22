package org.example;

import org.example.gui.MainFrame;

public class App {

    public App() {

    }
    public void startApp() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setPaneUI();
        mainFrame.makePublic();

    }
    public void quitApp() {
        System.out.println("App exited");
    }
}
