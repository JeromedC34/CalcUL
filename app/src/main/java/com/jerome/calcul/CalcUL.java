package com.jerome.calcul;

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

    public void setOperand(double newOperand) {
        if (!operation.equals("")) {
            operand = setCompute(operand, operation, newOperand);
        } else {
            operand = newOperand;
        }
    }

    public double setDivide() {
        operation = "/";
        return operand;
    }

    public double setMultiple() {
        operation = "*";
        return operand;
    }

    public double setMinus() {
        operation = "-";
        return operand;
    }

    public double setPlus() {
        operation = "+";
        return operand;
    }

    public double setEqual() {
        return operand;
    }

    private double setCompute(double operand1, String operation, double operand2) {
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

    private double doDivide(double operand1, double operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Division by zero!");
        } else {
            return operand1 / operand2;
        }
    }
}
