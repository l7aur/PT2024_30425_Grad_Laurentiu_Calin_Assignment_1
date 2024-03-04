package org.example;

import org.example.processing.Polynomial;
import org.example.processing.Triple;
import org.example.processing.Patterns;
import org.example.processing.StringPolynomial;

import java.util.ArrayList;

public class App {

    public App() {

    }
    public void startApp() {
        /*
        * For the moment
        * Read a string
        * convert it into a map of degree -> coeff
        * */
        StringPolynomial dummyPoly = new StringPolynomial();
        dummyPoly.read();
        ArrayList<String> arrayList = dummyPoly.tokenize();

        Polynomial polynomial1 = new Polynomial(1000);
        polynomial1.readPolynomial(dummyPoly.getPolyMapping());

        arrayList.clear();


        StringPolynomial dummyPoly1 = new StringPolynomial();
        dummyPoly1.read();
        arrayList = dummyPoly1.tokenize();

        Polynomial polynomial2 = new Polynomial(1000);
        polynomial2.readPolynomial(dummyPoly1.getPolyMapping());

        Polynomial p1 = polynomial2.add(polynomial1);
        p1.printPolynomial();
        Polynomial p2 = polynomial2.substract(polynomial1);
        p2.printPolynomial();

    }
    public void quitApp() {

    }
}
