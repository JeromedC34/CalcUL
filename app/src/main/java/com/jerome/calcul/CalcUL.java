package com.jerome.calcul;

import java.math.BigDecimal;

/**
 * Created by Human Booster on 04/10/2016.
 */
class CalcUL {
    private double operand;
    private String operation;
    private double lastOperand;
    private String lastOperation = "";

    public CalcUL() {
        clear();
    }

    public void clear() {
        operand = 0;
        operation = "";
        lastOperand = 0;
        lastOperation = "";
    }

    private void setOperand(double newOperand) throws CalcULException {
        if ("=".equals(operation) && !"".equals(lastOperation)) {
            operand = setCompute(newOperand, lastOperation, lastOperand);
        } else if (!"".equals(operation) && !"=".equals(operation)) {
            operand = setCompute(operand, operation, newOperand);
            lastOperand = newOperand;
        } else {
            operand = newOperand;
            lastOperation = "";
        }
    }

    public double setDivide(double newOperand) throws CalcULException {
        lastOperation = "";
        setOperand(newOperand);
        setOperation("/");
        return operand;
    }

    public double setMultiple(double newOperand) throws CalcULException {
        lastOperation = "";
        setOperand(newOperand);
        setOperation("*");
        return operand;
    }

    public double setMinus(double newOperand) throws CalcULException {
        lastOperation = "";
        setOperand(newOperand);
        setOperation("-");
        return operand;
    }

    public double setPlus(double newOperand) throws CalcULException {
        lastOperation = "";
        setOperand(newOperand);
        setOperation("+");
        return operand;
    }

    public double setXPowY(double newOperand) throws CalcULException {
        lastOperation = "";
        setOperand(newOperand);
        setOperation("x_pow_y");
        return operand;
    }

    public double setEqual(double newOperand) throws CalcULException {
        setOperand(newOperand);
        double result = operand;
        setOperation("=");
        return result;
    }

    public double setSin(double operand1) {
        return Math.sin(Math.toRadians(operand1));
    }

    public double setCos(double operand1) {
        return Math.cos(Math.toRadians(operand1));
    }

    public double setTan(double operand1) {
        return Math.tan(Math.toRadians(operand1));
    }

    public double setXPow2(double operand1) {
        return Math.pow(operand1, 2);
    }

    public double setSinInv(double operand1) {
        return Math.toDegrees(Math.asin(operand1));
    }

    public double setCosInv(double operand1) {
        return Math.toDegrees(Math.acos(operand1));
    }

    public double setTanInv(double operand1) {
        return Math.toDegrees(Math.atan(operand1));
    }

    public double setXPow3(double operand1) {
        return Math.pow(operand1, 3);
    }

    public double setEPowX(double operand1) {
        return Math.pow(Math.E, operand1);
    }

    public double set10PowX(double operand1) {
        return Math.pow(10, operand1);
    }

    public double set1DivX(double operand1) throws CalcULException {
        BigDecimal op1 = BigDecimal.valueOf(operand1);
        BigDecimal op2 = BigDecimal.valueOf(0);
        if (op1 == op2) {
            throw new CalcULException();
        } else {
            return 1 / operand1;
        }
    }

    public double setLn(double operand1) {
        return Math.log(operand1);
    }

    public double setLog(double operand1) {
        return Math.log10(operand1);
    }

    public double setSqrt(double operand1) {
        return Math.sqrt(operand1);
    }

    public double setPlusMinus(double operand1) {
        return -1 * operand1;
    }

    private void setOperation(String newOperation) {
        operation = newOperation;
        if (!"".equals(newOperation) && !"=".equals(newOperation)) {
            lastOperation = newOperation;
        }
    }

    private double setCompute(double operand1, String operation, double operand2) throws CalcULException {
        switch (operation) {
            case "+":
                return doPlus(operand1, operand2);
            case "-":
                return doMinus(operand1, operand2);
            case "*":
                return doMultiple(operand1, operand2);
            case "/":
                return doDivide(operand1, operand2);
            case "x_pow_y":
                return doXPowY(operand1, operand2);
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

    private double doXPowY(double operand1, double operand2) {
        return Math.pow(operand1, operand2);
    }
}
