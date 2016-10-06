package com.jerome.calcul;

import android.media.AudioManager;
import android.media.ToneGenerator;

import java.util.Arrays;

/**
 * Created by Human Booster on 04/10/2016.
 */
public class CalcUL {
    private static StringBuffer display;
    private static StringBuffer operand1;
    private static StringBuffer operand2;
    private static StringBuffer operation;
    private static boolean pending_operand;
    private static StringBuffer pending_operation;
    private final String defaultValue = "0";

    public CalcUL() {
        if (display == null) {
            display = new StringBuffer();
            operand1 = new StringBuffer();
            operand2 = new StringBuffer();
            operation = new StringBuffer();
            pending_operand = false;
            pending_operation = new StringBuffer();
            inputClear();
        }
    }

    public String getDisplay() {
        return display.toString();
    }

    private void setDisplay(String value) {
        display.delete(0, display.length());
        display.append(value.replaceAll("\\.0*$", ""));
    }

    private void setDisplay(double value) {
        setDisplay(String.valueOf(value).replaceAll("\\.0*$", ""));
    }

    public String manageAction(String myTag) {
        if (myTag.equals("C")) {
            inputClear();
        } else if (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0").contains(myTag)) {
            inputDigit(myTag);
        } else if (myTag.equals(".")) {
            inputDecimalSeparator(myTag);
        } else if (Arrays.asList("*", "-", "+", "/").contains(myTag)) {
            inputOperation(myTag);
        } else if (myTag.equals("=")) {
            inputEqual();
        }
        return getDisplay();
    }

    private void inputClear() {
        setDisplay(defaultValue);
        setOperand1("");
        setOperand2("");
        setOperation("");
        setPendingOperand(false);
        setPendingOperation("");
    }

    private void inputDigit(String myTag) {
        if (defaultValue.equals(display.toString())) {
            display.delete(0, display.length());
        }
        changePendingOperand(myTag);
    }

    private void inputDecimalSeparator(String myTag) {
        if (display.lastIndexOf(myTag) < 0) {
            changePendingOperand(myTag);
        }
    }

    private void changePendingOperand(String myTag) {
        stockPendingOperation();
        setOperand2("");
        if (!pending_operand) {
            if (myTag.equals(".")) {
                setDisplay(defaultValue);
            } else {
                setDisplay("");
            }
        }
        display.append(myTag);
        setPendingOperand(true);
    }

    private void inputOperation(String myTag) {
        if (!operand1.toString().equals("") && !operation.toString().equals("") && pending_operand) {
            inputEqual();
        }
        setOperand1(display.toString());
        setOperation("");
        setPendingOperation(myTag);
        setPendingOperand(false);
    }

    private double getOperand1() {
        double current_operand1;
        if (operand1.toString().equals("")) {
            current_operand1 = getOperand2();
        } else {
            current_operand1 = Double.valueOf(operand1.toString());
        }
        return current_operand1;
    }

    private void setOperand1(String value) {
        operand1.delete(0, operand1.length());
        operand1.append(value);
    }

    private double getOperand2() {
        double current_operand2;
        if (operand2.toString().equals("")) {
            current_operand2 = Double.valueOf(getDisplay());
            setOperand2(String.valueOf(current_operand2));
        } else {
            current_operand2 = Double.valueOf(operand2.toString());
        }
        setOperand2(String.valueOf(current_operand2));
        setPendingOperand(false);
        return current_operand2;
    }

    private void setOperand2(String value) {
        operand2.delete(0, operand2.length());
        operand2.append(value);
    }

    private void checkPendingOperation() {
        if (!pending_operation.toString().equals("")) {
            setOperation(pending_operation.toString());
            setPendingOperation("");
        }
    }

    private void inputEqual() {
        double current_operand1 = getOperand1();
        double current_operand2 = getOperand2();
        double current_result = Double.valueOf(defaultValue);
        checkPendingOperation();
        if (operation.toString().equals("/")) {
            current_result = doDiv(current_operand1, current_operand2);
        } else if (operation.toString().equals("*")) {
            current_result = doMul(current_operand1, current_operand2);
        } else if (operation.toString().equals("-")) {
            current_result = doMin(current_operand1, current_operand2);
        } else if (operation.toString().equals("+")) {
            current_result = doAdd(current_operand1, current_operand2);
        }
        setDisplay(current_result);
        setOperand1(getDisplay());
    }

    private double doDiv(double operand1, double operand2) {
        double current_result;
        if (operand2 != 0) {
            current_result = operand1 / operand2;
        } else {
            inputClear();
            current_result = Double.valueOf(defaultValue);
            ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
            toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
        }
        return current_result;
    }

    private double doMul(double operand1, double operand2) {
        double current_result = operand1 * operand2;
        return current_result;
    }

    private double doMin(double operand1, double operand2) {
        double current_result = operand1 - operand2;
        return current_result;
    }

    private double doAdd(double operand1, double operand2) {
        double current_result = operand1 + operand2;
        return current_result;
    }

    private void stockPendingOperation() {
        if (!pending_operation.toString().equals("")) {
            setOperation(pending_operation.toString());
            setPendingOperation("");
            setDisplay(defaultValue);
        }
    }

    private void setPendingOperation(String value) {
        pending_operation.delete(0, pending_operation.length());
        pending_operation.append(value);
    }

    private void setPendingOperand(boolean value) {
        pending_operand = value;
    }

    private void setOperation(String value) {
        operation.delete(0, operation.length());
        operation.append(value);
    }
}
