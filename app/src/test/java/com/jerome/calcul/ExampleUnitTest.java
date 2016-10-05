package com.jerome.calcul;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void checkInputDigit() throws Exception {
        CalcUL myCalc = new CalcUL();
        assertEquals("1", myCalc.manageAction("1"));
    }
    @Test
    public void checkInputCommaDigit() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction(".");
        assertEquals("0.1", myCalc.manageAction("1"));
    }
    @Test
    public void checkComputePlus() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("2");
        myCalc.manageAction("+");
        myCalc.manageAction("7");
        assertEquals("9", myCalc.manageAction("="));
    }
    @Test
    public void checkComputeMinus() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("9");
        myCalc.manageAction("-");
        myCalc.manageAction("7");
        assertEquals("2", myCalc.manageAction("="));
    }
    @Test
    public void checkComputeTimes() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("2");
        myCalc.manageAction("*");
        myCalc.manageAction("7");
        assertEquals("14", myCalc.manageAction("="));
    }
    @Test
    public void checkComputeDiv() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("8");
        myCalc.manageAction("/");
        myCalc.manageAction("2");
        assertEquals("4", myCalc.manageAction("="));
    }
    @Test
    public void checkComputeWithoutSecondOperand() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("8");
        myCalc.manageAction("*");
        assertEquals("64", myCalc.manageAction("="));
    }
    @Test
    public void checkComputeSeveralOperationsWithoutEqual() throws Exception {
        CalcUL myCalc = new CalcUL();
        myCalc.manageAction("C");
        myCalc.manageAction("8");
        myCalc.manageAction("*");
        myCalc.manageAction("2");
        assertEquals("16", myCalc.manageAction("+"));
    }
}