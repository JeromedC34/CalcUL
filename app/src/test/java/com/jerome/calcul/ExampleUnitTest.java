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

    @Test
    public void checkXPowY() throws Exception {
        myCalc.setXPowY(8);
        assertEquals(64, myCalc.setEqual(2), 0);
    }

    @Test
    public void checkPlusMinus() throws Exception {
        assertEquals(-2, myCalc.setPlusMinus(2), 0);
    }

    @Test
    public void checkSin() throws Exception {
        assertEquals(1, myCalc.setSin(90), 0);
    }

    @Test
    public void checkCos() throws Exception {
        assertEquals(-1, myCalc.setCos(180), 0);
    }

    @Test
    public void checkTan() throws Exception {
        assertEquals(1, myCalc.setTan(Math.toDegrees(Math.PI / 4)), 0.0000000000001);
    }

    @Test
    public void checkXPow2() throws Exception {
        assertEquals(16, myCalc.setXPow2(4), 0);
    }

    @Test
    public void checkSinInv() throws Exception {
        assertEquals(90, myCalc.setSinInv(1), 0);
    }

    @Test
    public void checkCosInv() throws Exception {
        assertEquals(180, myCalc.setCosInv(-1), 0);
    }

    @Test
    public void checkTanInv() throws Exception {
        assertEquals(Math.toDegrees(Math.PI / 4), myCalc.setTanInv(1), 0.0000000000001);
    }

    @Test
    public void checkXPow3() throws Exception {
        assertEquals(64, myCalc.setXPow3(4), 0);
    }

    @Test
    public void checkEPowX() throws Exception {
        assertEquals(Math.E * Math.E, myCalc.setEPowX(2), 0);
    }

    @Test
    public void checkEPow0() throws Exception {
        assertEquals(1, myCalc.setEPowX(0), 0);
    }

    @Test
    public void check10PowX() throws Exception {
        assertEquals(10000, myCalc.set10PowX(4), 0);
    }

    @Test
    public void check1DivX() throws Exception {
        assertEquals(0.25, myCalc.set1DivX(4), 0);
    }

    @Test
    public void checkLn() throws Exception {
        assertEquals(1, myCalc.setLn(Math.E), 0);
    }

    @Test
    public void checkLog() throws Exception {
        assertEquals(4, myCalc.setLog(10000), 0);
    }

    @Test
    public void checkSqrt() throws Exception {
        assertEquals(8, myCalc.setSqrt(64), 0);
    }
}