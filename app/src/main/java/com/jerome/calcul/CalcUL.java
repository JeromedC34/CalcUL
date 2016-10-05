package com.jerome.calcul;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by Human Booster on 04/10/2016.
 */
public class CalcUL {
    private static StringBuffer display;
    private static StringBuffer operand1;
    private static StringBuffer operand2;
    private static StringBuffer operation;
    private static StringBuffer current_operation;
    private String defaultValue = "0";

    public CalcUL() {
        if (display == null) {
            display = new StringBuffer();
            operand1 = new StringBuffer();
            operand2 = new StringBuffer();
            operation = new StringBuffer();
            current_operation = new StringBuffer();
            inputClear();
        }
    }

    public String getDisplay() {
        return display.toString();
    }

    private void setDisplay(double value) {
        setDisplay(String.valueOf(value).replaceAll("\\.0*$", ""));
    }

    public void inputClear() {
        setDisplay(defaultValue);
        setOperand1("");
        setOperand2("");
        setOperation("");
        setCurrentOperation("");
    }

    public void inputDigit(String myTag) {
        setOperation(true);
        if (defaultValue.equals(display.toString())) {
            display.delete(0, display.length());
        }
        setOperand2("");
        display.append(myTag);
    }

    public void inputDecimalSeparator(String myTag) {
        if (display.lastIndexOf(myTag) < 0) {
            setOperation(true);
            display.append(myTag);
            setOperand2("");
        }
    }

    public void inputOperation(String myTag) {
        if (!operation.toString().equals("") && !operand1.toString().equals("") && current_operation.toString().equals("")) {
            inputEqual();
        }
        setOperand1(display.toString());
        setCurrentOperation(myTag);
    }

    public void inputEqual() {
        setOperation(false);
        double current_operand1;
        double current_operand2;
        if (operand2.toString().equals("")) {
            current_operand2 = Double.valueOf(getDisplay());
            setOperand2(String.valueOf(current_operand2));
        } else {
            current_operand2 = Double.valueOf(operand2.toString());
        }
        double current_result;
        if (operand1.toString().equals("")) {
            current_operand1 = current_operand2;
        } else {
            current_operand1 = Double.valueOf(operand1.toString());
        }
        if (operation.toString().equals("/")) {
            if (current_operand2 != 0) {
                current_result = current_operand1 / current_operand2;
                Log.e("my_div_calc", current_result + " = " + current_operand1 + " / " + current_operand2);
                setDisplay(current_result);
                setOperand1(getDisplay());
            } else {
                ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
            }
        } else if (operation.toString().equals("*")) {
            current_result = current_operand1 * current_operand2;
            setDisplay(current_result);
            setOperand1(getDisplay());
        } else if (operation.toString().equals("-")) {
            current_result = current_operand1 - current_operand2;
            setDisplay(current_result);
            setOperand1(getDisplay());
        } else if (operation.toString().equals("+")) {
            current_result = current_operand1 + current_operand2;
            setDisplay(current_result);
            setOperand1(getDisplay());
        }
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

    private void setDisplay(String value) {
        display.delete(0, display.length());
        display.append(value.replaceAll("\\.0*$", ""));
    }

    private void setOperand1(String value) {
        operand1.delete(0, operand1.length());
        operand1.append(value);
    }

    private void setOperand2(String value) {
        operand2.delete(0, operand2.length());
        operand2.append(value);
    }

    private void setCurrentOperation(String value) {
        current_operation.delete(0, current_operation.length());
        current_operation.append(value);
    }

    private void setOperation(boolean resetDisplay) {
        if (!current_operation.toString().equals("")) {
            setOperation(current_operation.toString());
            setCurrentOperation("");
            if (resetDisplay) {
                setDisplay(defaultValue);
            }
        }
    }

    private void setOperation(String value) {
        operation.delete(0, operation.length());
        operation.append(value);
    }
}
