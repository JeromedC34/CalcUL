package com.jerome.calcul;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    CalcUL myCalc;
    @Before
    public void init() {
        myCalc = new CalcUL();
    }
//    @Test
//    public void checkInputDigit() throws Exception {
//        myCalc.manageAction("C");
//        assertEquals("1", myCalc.manageAction("1"));
//    }
//    @Test
//    public void checkInputCommaDigit() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction(".");
//        assertEquals("0.1", myCalc.manageAction("1"));
//    }
//    @Test
//    public void checkComputePlus() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("2");
//        myCalc.manageAction("+");
//        myCalc.manageAction("7");
//        assertEquals("9", myCalc.manageAction("="));
//    }
//    @Test
//    public void checkComputeMinus() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("9");
//        myCalc.manageAction("-");
//        myCalc.manageAction("7");
//        assertEquals("2", myCalc.manageAction("="));
//    }
//    @Test
//    public void checkComputeTimes() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("2");
//        myCalc.manageAction("*");
//        myCalc.manageAction("7");
//        assertEquals("14", myCalc.manageAction("="));
//    }
//    @Test
//    public void checkComputeDiv() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("/");
//        myCalc.manageAction("2");
//        assertEquals("4", myCalc.manageAction("="));
//    }
//    @Test
//    public void checkComputeWithoutSecondOperand() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("*");
//        assertEquals("64", myCalc.manageAction("="));
//    }
//    @Test
//    public void checkComputeSeveralOperationsWithoutEqual() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("*");
//        myCalc.manageAction("2");
//        assertEquals("16", myCalc.manageAction("+"));
//    }
//    @Test
//    public void checkNewNumberInputAfterCompute() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("*");
//        myCalc.manageAction("2");
//        myCalc.manageAction("=");
//        assertEquals("5", myCalc.manageAction("5"));
//    }
//    @Test
//    public void checkNoExtraZeroInInput() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("*");
//        assertEquals("5", myCalc.manageAction("5"));
//    }
//    @Test
//    public void checkWaitOperandAfterEqualThenOperation() throws Exception {
//        myCalc.manageAction("C");
//        myCalc.manageAction("8");
//        myCalc.manageAction("*");
//        myCalc.manageAction("4");
//        myCalc.manageAction("=");
//        assertEquals("32", myCalc.manageAction("*"));
//    }
    @Test
    public void checkPlusSimple() throws Exception {
        assertEquals(3, myCalc.doPlus(1, 2), 0);
    }
    @Test
    public void checkPlusNegative() throws Exception {
        assertEquals(-1, myCalc.doPlus(1, -2), 0);
    }
    @Test
    public void checkMinusSimple() throws Exception {
        assertEquals(3, myCalc.doMinus(5, 2), 0);
    }
    @Test
    public void checkMinusNegative() throws Exception {
        assertEquals(-1, myCalc.doMinus(2, 3), 0);
    }
    @Test
    public void checkMultipleSimple() throws Exception {
        assertEquals(3, myCalc.doMinus(5, 2), 0);
    }
    @Test
    public void checkMultipleNegative() throws Exception {
        assertEquals(-1, myCalc.doMinus(2, 3), 0);
    }
}