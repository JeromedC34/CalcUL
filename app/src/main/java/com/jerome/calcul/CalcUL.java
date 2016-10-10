package com.jerome.calcul;

import java.math.BigDecimal;

/**
 * Created by Human Booster on 04/10/2016.
 */
class CalcUL {
    private double operand;
    private String operation;

    public CalcUL() {
        clear();
    }

    public void clear() {
        operand = 0;
        operation = "";
    }

    private void setOperand(double newOperand) throws CalcULException  {
        if (!"".equals(operation)) {
            operand = setCompute(operand, operation, newOperand);
        } else {
            operand = newOperand;
        }
    }

    public double setDivide(double newOperand) throws CalcULException  {
        setOperand(newOperand);
        operation = "/";
        return operand;
    }

    public double setMultiple(double newOperand) throws CalcULException  {
        setOperand(newOperand);
        operation = "*";
        return operand;
    }

    public double setMinus(double newOperand) throws CalcULException  {
        setOperand(newOperand);
        operation = "-";
        return operand;
    }

    public double setPlus(double newOperand) throws CalcULException  {
        setOperand(newOperand);
        operation = "+";
        return operand;
    }

    public double setEqual(double newOperand) throws CalcULException  {
        setOperand(newOperand);
        double result = operand;
        clear();
        return result;
    }

    private double setCompute(double operand1, String operation, double operand2) throws CalcULException  {
        switch (operation) {
            case "+":
                return doPlus(operand1, operand2);
            case "-":
                return doMinus(operand1, operand2);
            case "*":
                return doMultiple(operand1, operand2);
            case "/":
                return doDivide(operand1, operand2);
            default:
                return this.operand;
        }
    }

    private double doPlus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private double doMinus(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private double doMultiple(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private double doDivide(double operand1, double operand2) throws CalcULException {
        BigDecimal op1 = BigDecimal.valueOf(operand2);
        BigDecimal op2 = BigDecimal.valueOf(0);
        if (op1 == op2) {
            throw new CalcULException();
        } else {
            return operand1 / operand2;
        }
    }
}
