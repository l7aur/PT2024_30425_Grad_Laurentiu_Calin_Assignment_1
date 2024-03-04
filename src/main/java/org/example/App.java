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

//        StringPolynomial dummyPoly = new StringPolynomial();
//        StringPolynomial dummyPoly1 = new StringPolynomial();
//
//        Scanner scanner = new Scanner(System.in);
//
//        dummyPoly.read(scanner.nextLine());
//        dummyPoly1.read(scanner.nextLine());
//
//        scanner.close();
//
//        dummyPoly.tokenize();
//        dummyPoly1.tokenize();
//
//        Polynomial polynomial1 = new Polynomial(1000);
//        Polynomial polynomial2 = new Polynomial(1000);
//
//        polynomial1.readPolynomial(dummyPoly.getPolyMapping());
//        polynomial2.readPolynomial(dummyPoly1.getPolyMapping());
//
//        polynomial1.printPolynomial();
//        polynomial2.printPolynomial();
//
//        Polynomial p1 = polynomial1.add(polynomial2);
//        System.out.print("addition result:");
//        p1.printPolynomial();
//        System.out.print("substraction result:");
//        Polynomial p2 = polynomial1.substract(polynomial2);
//        p2.printPolynomial();
//        System.out.print("derivation result:");
//        Polynomial p3 = polynomial1.derivate();
//        p3.printPolynomial();
//        System.out.print("integration result:");
//        Polynomial p4 = polynomial1.integrate();
//        p4.printPolynomial();

        MainFrame mainFrame = new MainFrame();
        mainFrame.setPaneUI();
        mainFrame.makePublic();

    }
    public void quitApp() {

    }
}
