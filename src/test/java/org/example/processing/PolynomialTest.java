package org.example.processing;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {
    @Test
    public void checkAddition1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //X^2+X+1
            arrayList1.add(new Pair<>(2,1.0));
            arrayList1.add(new Pair<>(1,1.0));
            arrayList1.add(new Pair<>(0,1.0));
        }{  //-3X+8
            arrayList2.add(new Pair<>(1,-3.0));
            arrayList2.add(new Pair<>(0,8.0));
        }{  //X^2-2X+9
            arrayList3.add(new Pair<>(2,1.0));
            arrayList3.add(new Pair<>(1,-2.0));
            arrayList3.add(new Pair<>(0, 9.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.add(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.add(polynomial1).getMap());
    }
    @Test
    public void checkAddition2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //-X^7+100X^4+50X^3-23X-5
            arrayList1.add(new Pair<>(7,-1.0));
            arrayList1.add(new Pair<>(4,100.0));
            arrayList1.add(new Pair<>(3,50.0));
            arrayList1.add(new Pair<>(1,-23.0));
            arrayList1.add(new Pair<>(0,-5.0));
        }{  //X^7-100X^4-50X^3+23X+5
            arrayList2.add(new Pair<>(7,1.0));
            arrayList2.add(new Pair<>(4,-100.0));
            arrayList2.add(new Pair<>(3,-50.0));
            arrayList2.add(new Pair<>(1,23.0));
            arrayList2.add(new Pair<>(0,5.0));
        }{  //0
            arrayList3.add(new Pair<>(0,0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.add(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.add(polynomial1).getMap());
    }
    @Test
    public void checkSubtraction1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
        {   //X^5-X^3+30*X-5
            arrayList1.add(new Pair<>(5,1.0));
            arrayList1.add(new Pair<>(3,-1.0));
            arrayList1.add(new Pair<>(1,30.0));
            arrayList1.add(new Pair<>(0,-5.0));
        }{  //7X^2-52
            arrayList2.add(new Pair<>(2,7.0));
            arrayList2.add(new Pair<>(0,-52.0));
        }{  //X^5-X^3-7X^2+30X+47  //first - second
            arrayList3.add(new Pair<>(5,1.0));
            arrayList3.add(new Pair<>(3,-1.0));
            arrayList3.add(new Pair<>(2,-7.0));
            arrayList3.add(new Pair<>(1,30.0));
            arrayList3.add(new Pair<>(0,47.0));
        }{  //-X^5+X^3+7X^2-30X-47 //second - first
            arrayList4.add(new Pair<>(5,-1.0));
            arrayList4.add(new Pair<>(3,1.0));
            arrayList4.add(new Pair<>(2,7.0));
            arrayList4.add(new Pair<>(1,-30.0));
            arrayList4.add(new Pair<>(0,-47.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        Polynomial polynomial4 = new Polynomial(arrayList4);
        assertEquals(polynomial3.getMap(), polynomial1.subtract(polynomial2).getMap());
        assertEquals(polynomial4.getMap(), polynomial2.subtract(polynomial1).getMap());
    }
    @Test
    public void checkSubtraction2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
        {   //100X^999-72X^300+30*X-50
            arrayList1.add(new Pair<>(999,100.0));
            arrayList1.add(new Pair<>(300,-72.0));
            arrayList1.add(new Pair<>(1,30.0));
            arrayList1.add(new Pair<>(0,-50.0));
        }{  //1201X^999-31X^300+30X+20
            arrayList2.add(new Pair<>(999,1201.0));
            arrayList2.add(new Pair<>(300,-31.0));
            arrayList2.add(new Pair<>(1,30.0));
            arrayList2.add(new Pair<>(0,20.0));
        }{  //-1101X^999-41X^300-70  //first - second
            arrayList3.add(new Pair<>(999,-1101.0));
            arrayList3.add(new Pair<>(300,-41.0));
            arrayList3.add(new Pair<>(0,-70.0));
        }{  //1101X^999+41X^300+70  //second - first
            arrayList4.add(new Pair<>(999,1101.0));
            arrayList4.add(new Pair<>(300,41.0));
            arrayList4.add(new Pair<>(0,70.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        Polynomial polynomial4 = new Polynomial(arrayList4);
        assertEquals(polynomial3.getMap(), polynomial1.subtract(polynomial2).getMap());
        assertEquals(polynomial4.getMap(), polynomial2.subtract(polynomial1).getMap());
    }
    @Test
    public void checkSubtraction3(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //X+12
            arrayList1.add(new Pair<>(1,1.0));
            arrayList1.add(new Pair<>(0,12.0));
        }{  //X+12
            arrayList2.add(new Pair<>(1,1.0));
            arrayList2.add(new Pair<>(0,12.0));
        }{  //0
            arrayList3.add(new Pair<>(0,0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.subtract(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.subtract(polynomial1).getMap());
    }
    @Test
    public void checkMultiplication1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //X+1
            arrayList1.add(new Pair<>(1,1.0));
            arrayList1.add(new Pair<>(0,1.0));
        }{  //X+9
            arrayList2.add(new Pair<>(1,1.0));
            arrayList2.add(new Pair<>(0,9.0));
        }{  //X^2+10X+9
            arrayList3.add(new Pair<>(2,1.0));
            arrayList3.add(new Pair<>(1,10.0));
            arrayList3.add(new Pair<>(0, 9.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.multiply(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.multiply(polynomial1).getMap());
    }
    @Test
    public void checkMultiplication2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //10X^5+3X^4-2X^3+1X^2-41X+3
            arrayList1.add(new Pair<>(5,10.0));
            arrayList1.add(new Pair<>(4,3.0));
            arrayList1.add(new Pair<>(3,-2.0));
            arrayList1.add(new Pair<>(2,1.0));
            arrayList1.add(new Pair<>(1,-41.0));
            arrayList1.add(new Pair<>(0,3.0));
        }{  //19X^6-3X^5+12X^3-12X^2-1X^1-9
            arrayList2.add(new Pair<>(6,19.0));
            arrayList2.add(new Pair<>(5,-3.0));
            arrayList2.add(new Pair<>(3,12.0));
            arrayList2.add(new Pair<>(2,-12.0));
            arrayList2.add(new Pair<>(1,-1.0));
            arrayList2.add(new Pair<>(0,-9.0));
        }{  //190X^11+27X^10−47X^9+145X^8−866X^7+110X^6−66X^5−529X^4+545X^3−4X^2+366X−27
            arrayList3.add(new Pair<>(11,190.0));
            arrayList3.add(new Pair<>(10,27.0));
            arrayList3.add(new Pair<>(9,-47.0));
            arrayList3.add(new Pair<>(8,145.0));
            arrayList3.add(new Pair<>(7,-866.0));
            arrayList3.add(new Pair<>(6,110.0));
            arrayList3.add(new Pair<>(5,-66.0));
            arrayList3.add(new Pair<>(4, -529.0));
            arrayList3.add(new Pair<>(3, 545.0));
            arrayList3.add(new Pair<>(2, -4.0));
            arrayList3.add(new Pair<>(1, 366.0));
            arrayList3.add(new Pair<>(0, -27.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.multiply(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.multiply(polynomial1).getMap());
    }
    @Test
    public void checkMultiplication3(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //X+1
            arrayList1.add(new Pair<>(1,1.0));
            arrayList1.add(new Pair<>(0,1.0));
        }{  //0
            arrayList2.add(new Pair<>(0,0.0));
        }{  //0
            arrayList3.add(new Pair<>(0, 0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.multiply(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.multiply(polynomial1).getMap());
    }
    @Test
    public void checkDivision1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        {   //X+1
            arrayList1.add(new Pair<>(1,1.0));
            arrayList1.add(new Pair<>(0,1.0));
        }{  //0
            arrayList2.add(new Pair<>(0,0.0));
        }{  //0
            arrayList3.add(new Pair<>(0, 0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        assertEquals(polynomial3.getMap(), polynomial1.divide(polynomial2).getMap());
        assertEquals(polynomial3.getMap(), polynomial2.divide(polynomial1).getMap());
    }
    @Test
    public void checkDivision2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
        {   //X^3+3X^2+3X+1
            arrayList1.add(new Pair<>(3,1.0));
            arrayList1.add(new Pair<>(2,3.0));
            arrayList1.add(new Pair<>(1,3.0));
            arrayList1.add(new Pair<>(0,1.0));
        }{  //X+1
            arrayList2.add(new Pair<>(1,1.0));
            arrayList2.add(new Pair<>(0,1.0));
        }{  //X^2+2X+1
            arrayList3.add(new Pair<>(2, 1.0));
            arrayList3.add(new Pair<>(1, 2.0));
            arrayList3.add(new Pair<>(0, 1.0));
        }{  //0
            arrayList4.add(new Pair<>(0, 0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        Polynomial polynomial4 = new Polynomial(arrayList4);
        assertEquals(polynomial3.getMap(), polynomial1.divide(polynomial2).getMap());
        assertEquals(polynomial4.getMap(), polynomial2.divide(polynomial1).getMap());
    }
    @Test
    public void checkDivision3(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
        {   //X^5+3X^3-3X^2+5X-5
            arrayList1.add(new Pair<>(5,1.0));
            arrayList1.add(new Pair<>(3,3.0));
            arrayList1.add(new Pair<>(2,-3.0));
            arrayList1.add(new Pair<>(1,5.0));
            arrayList1.add(new Pair<>(0,-5.0));
        }{  //X^2+7
            arrayList2.add(new Pair<>(2,1.0));
            arrayList2.add(new Pair<>(0,7.0));
        }{  //X^3-4X-3q 33X+16r
            arrayList3.add(new Pair<>(3, 1.0));
            arrayList3.add(new Pair<>(1, -4.0));
            arrayList3.add(new Pair<>(0, -3.0));
        }{  //0q X^2+7r
            arrayList4.add(new Pair<>(0, 0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        Polynomial polynomial4 = new Polynomial(arrayList4);
        assertEquals(polynomial3.getMap(), polynomial1.divide(polynomial2).getMap());
        assertEquals(polynomial4.getMap(), polynomial2.divide(polynomial1).getMap());
    }
    @Test
    public void checkDivision4(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
        {   //3X^7-3X^5+10X^3+5X^2-50
            arrayList1.add(new Pair<>(7,3.0));
            arrayList1.add(new Pair<>(5,-3.0));
            arrayList1.add(new Pair<>(3,10.0));
            arrayList1.add(new Pair<>(2,5.0));
            arrayList1.add(new Pair<>(0,-50.0));
        }{  //2X^3+4
            arrayList2.add(new Pair<>(3,2.0));
            arrayList2.add(new Pair<>(0,4.0));
        }{  //3/2X^4-3/2X^2-3X+5q 11X^2+12X-70r
            arrayList3.add(new Pair<>(4, 3/2.0));
            arrayList3.add(new Pair<>(2, -3/2.0));
            arrayList3.add(new Pair<>(1, -3.0));
            arrayList3.add(new Pair<>(0, 5.0));
        }{  //0q 2X^3+4r
            arrayList4.add(new Pair<>(0, 0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        Polynomial polynomial3 = new Polynomial(arrayList3);
        Polynomial polynomial4 = new Polynomial(arrayList4);
        assertEquals(polynomial3.getMap(), polynomial1.divide(polynomial2).getMap());
        assertEquals(polynomial4.getMap(), polynomial2.divide(polynomial1).getMap());
    }
//    @Test
//    public void checkDivision5(){
//        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
//        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
//        ArrayList<Pair <Integer, Double>> arrayList3 = new ArrayList<>();
//        ArrayList<Pair <Integer, Double>> arrayList4 = new ArrayList<>();
//        {   //11X^3+7X^2-5X+3
//            arrayList1.add(new Pair<>(3,11.0));
//            arrayList1.add(new Pair<>(2,7.0));
//            arrayList1.add(new Pair<>(1,-5.0));
//            arrayList1.add(new Pair<>(0,3.0));
//        }{  //13X+23
//            arrayList2.add(new Pair<>(1,13.0));
//            arrayList2.add(new Pair<>(0,23.0));
//        }{  //11/13X^2-162/169X+2881/2197q -59672/2197r
//            arrayList3.add(new Pair<>(2, 11/13.0));
//            arrayList3.add(new Pair<>(1, -162/169.0));
//            arrayList3.add(new Pair<>(0, 2881/2197.0));
//        }{  //0q 13X+23r
//            arrayList4.add(new Pair<>(0, 0.0));
//        }
//        Polynomial polynomial1 = new Polynomial(arrayList1);
//        Polynomial polynomial2 = new Polynomial(arrayList2);
//        Polynomial polynomial3 = new Polynomial(arrayList3);
//        Polynomial polynomial4 = new Polynomial(arrayList4);
//        assertEquals(polynomial3.getMap(), polynomial1.divide(polynomial2).getMap());
//        assertEquals(polynomial4.getMap(), polynomial2.divide(polynomial1).getMap());
//    }
    @Test
    public void checkDerivative1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        {   //11X^3+7X^2-5X+3
            arrayList1.add(new Pair<>(3,11.0));
            arrayList1.add(new Pair<>(2,7.0));
            arrayList1.add(new Pair<>(1,-5.0));
            arrayList1.add(new Pair<>(0,3.0));
        }{  //33X^2+14X-5
            arrayList2.add(new Pair<>(2,33.0));
            arrayList2.add(new Pair<>(1,14.0));
            arrayList2.add(new Pair<>(0,-5.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        assertEquals(polynomial2.getMap(), polynomial1.derivate().getMap());
    }
    @Test
    public void checkDerivative2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        {   //0
            arrayList1.add(new Pair<>(0,0.0));
        }{  //0
            arrayList2.add(new Pair<>(0,0.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        assertEquals(polynomial2.getMap(), polynomial1.derivate().getMap());
    }
    @Test
    public void checkIntegration1(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        {   //X^2+5X+3
            arrayList1.add(new Pair<>(2,1.0));
            arrayList1.add(new Pair<>(1,5.0));
            arrayList1.add(new Pair<>(0,3.0));
        }{  //1/3X^3+5/2X^2+3X
            arrayList2.add(new Pair<>(3,1/3.0));
            arrayList2.add(new Pair<>(2,5/2.0));
            arrayList2.add(new Pair<>(1,3.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        assertEquals(polynomial2.getMap(), polynomial1.integrate().getMap());
    }
    @Test
    public void checkIntegration2(){
        ArrayList<Pair <Integer, Double>> arrayList1 = new ArrayList<>();
        ArrayList<Pair <Integer, Double>> arrayList2 = new ArrayList<>();
        {   //-9X^8-5X^4+11
            arrayList1.add(new Pair<>(8,-9.0));
            arrayList1.add(new Pair<>(4,-5.0));
            arrayList1.add(new Pair<>(0,11.0));
        }{  //-X^9-X^5+11X
            arrayList2.add(new Pair<>(9,-1.0));
            arrayList2.add(new Pair<>(5,-1.0));
            arrayList2.add(new Pair<>(1,11.0));
        }
        Polynomial polynomial1 = new Polynomial(arrayList1);
        Polynomial polynomial2 = new Polynomial(arrayList2);
        assertEquals(polynomial2.getMap(), polynomial1.integrate().getMap());
    }
}