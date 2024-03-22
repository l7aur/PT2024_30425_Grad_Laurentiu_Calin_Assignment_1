package org.example.processing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StringPolynomialTest {
    @Test
    public void testConversionToMap1() {
        String string = "X^100-2*X^4+2-300X^2-100X";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(100, 1.0);
            p.put(4, -2.0);
            p.put(2, -300.0);
            p.put(1, -100.0);
            p.put(0, 2.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap2() {
        String string = "X^7-X^6+X^5-X^4+X^3-1";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(7,1.0);
            p.put(6,-1.0);
            p.put(5,1.0);
            p.put(4,-1.0);
            p.put(3,1.0);
            p.put(0,-1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap3() {
        String string = "X";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap4() {
        String string = "1";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(0,1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap5() {
        String string = "-1";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(0,-1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap6() {
        String string = "-X";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,-1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap7() {
        String string = "2X";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,2.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap8() {
        String string = "-X^1000";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1000,-1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap9() {
        String string = "-X+2X^2";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,-1.0);
            p.put(2,2.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap10() {
        String string = "X-X^2-X^3-X^4-X^5";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,1.0);
            p.put(2,-1.0);
            p.put(3,-1.0);
            p.put(4,-1.0);
            p.put(5,-1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap11() {
        String string = "X*100";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(1,100.0);
        }
        assertNotEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap12() {
        String string = "1*X^2+X^2";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(2,2.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap13() {
        String string = "1Xa";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap14() {
        String string = "";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        assertEquals(p, poly.convertToPoly().getMap());
    }
    @Test
    public void testConversionToMap15() {
        String string = "1*X^0";
        StringPolynomial poly = new StringPolynomial(string);
        Map<Integer, Double> p = new HashMap<>();
        {
            p.put(0,1.0);
        }
        assertEquals(p, poly.convertToPoly().getMap());
    }
}