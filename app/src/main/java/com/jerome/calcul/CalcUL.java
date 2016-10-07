package com.jerome.calcul;

/**
 * Created by Human Booster on 04/10/2016.
 */
class CalcUL {
    public double doPlus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public double doMinus(double operand1, double operand2) {
        return operand1 - operand2;
    }

    public double doMultiple(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public double doDivide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Division by zero!");
        } else {
            return operand1 / operand2;
        }
    }
}
