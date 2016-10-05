package com.jerome.calcul;

import android.media.AudioManager;
import android.media.ToneGenerator;

import java.util.Arrays;

/**
 * Created by Human Booster on 04/10/2016.
 */
public class CalcUL {
    private static StringBuffer result;
    private static StringBuffer operand1;
    private static StringBuffer current_operation;
    private static StringBuffer operation;
    private String defaultResult = "0";
    public CalcUL(){
        if (result == null) {
            result = new StringBuffer(defaultResult);
            operand1 = new StringBuffer(defaultResult);
            current_operation = new StringBuffer("");
            operation = new StringBuffer("");
        }
    }
    public String getResult(){
        return result.toString();
    }
    public String manageAction(String myTag) {
        if (myTag.equals("C")) {
            setResult(defaultResult);
            setOperand1(defaultResult);
            setOperation("");
            setCurrentOperation("");
        } else if (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0").contains(myTag)) {
            setOperation();
            if (defaultResult.equals(result.toString())) {
                result.delete(0, result.length());
            }
            result.append(myTag);
        } else if (myTag.equals(".")) {
            if (result.lastIndexOf(myTag) < 0) {
                setOperation();
                result.append(myTag);
            }
        } else if (Arrays.asList("*", "-", "+", "/").contains(myTag)) {
            setOperand1(result.toString());
            setCurrentOperation(myTag);
        } else if (myTag.equals("=")) {
            if (!operand1.toString().equals("") && !operation.toString().equals("")) {
                double current_operand1 = Double.valueOf(operand1.toString());
                double current_operand2 = Double.valueOf(getResult());
                double current_Result;
                if (operation.toString().equals("/")) {
                    if (current_operand2 != 0) {
                        current_Result = current_operand1 / current_operand2;
                        setResult(current_Result);
                    } else {
                        ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
                        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200);
                    }
                } else if (operation.toString().equals("*")) {
                    current_Result = current_operand1 * current_operand2;
                    setResult(current_Result);
                } else if (operation.toString().equals("-")) {
                    current_Result = current_operand1 - current_operand2;
                    setResult(current_Result);
                } else if (operation.toString().equals("+")) {
                    current_Result = current_operand1 + current_operand2;
                    setResult(current_Result);
                }
            }
        }
        return getResult();
    }
    private void setResult(String value) {
        result.delete(0, result.length());
        result.append(value);
    }
    private void setResult(double value) {
        setResult(String.valueOf(value).replaceAll("[.0]*$", ""));
    }
    private void setOperand1(String value) {
        operand1.delete(0, operand1.length());
        operand1.append(value);
    }
    private void setCurrentOperation(String value) {
        current_operation.delete(0, current_operation.length());
        current_operation.append(value);
    }
    private void setOperation() {
        if (!current_operation.toString().equals("")) {
            setOperation(current_operation.toString());
            setCurrentOperation("");
            setResult(defaultResult);
        }
    }
    private void setOperation(String value) {
        operation.delete(0, operation.length());
        operation.append(value);
    }
 }
