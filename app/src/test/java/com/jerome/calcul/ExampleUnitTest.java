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
        myCalc.clear();
    }
    @Test
    public void checkPlus() throws Exception {
        myCalc.setPlus(2);
        assertEquals(10, myCalc.setEqual(8), 0);
    }
    @Test
    public void checkPlusWithDecimal() throws Exception {
        myCalc.setPlus(2.2);
        assertEquals(10.2, myCalc.setEqual(8), 0);
    }
    @Test
    public void checkMinus() throws Exception {
        myCalc.setMinus(18);
        assertEquals(10, myCalc.setEqual(8), 0);
    }
    @Test
    public void checkMultiple() throws Exception {
        myCalc.setMultiple(5);
        assertEquals(10, myCalc.setEqual(2), 0);
    }
    @Test
    public void checkDivide() throws Exception {
        myCalc.setDivide(50);
        assertEquals(10, myCalc.setEqual(5), 0);
    }
    @Test
    public void checkComputeSeveralOperationsWithoutEqual() throws Exception {
        myCalc.setMultiple(8);
        assertEquals(16, myCalc.setPlus(2), 0);
    }
    @Test
    public void checkNewNumberInputAfterCompute() throws Exception {
        myCalc.setMultiple(8);
        myCalc.setEqual(2);
        assertEquals(5, myCalc.setPlus(5), 0);
    }
}