package com.jerome.calcul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String defaultValue = "0";
    private static CalcUL calcUL = new CalcUL();
    private static String display = defaultValue;
    private static String lastOperand = "";
    private static String lastOperation = "";
    private static boolean operandBeingInput = false;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_result);
        setDisplay(display);
    }

    public void manageAction(View view) {
        switch (view.getTag().toString()) {
            case "C":
                chooseClear();
                break;
            case "/":
                chooseDivide();
                break;
            case "*":
                chooseMultiple();
                break;
            case "-":
                chooseMinus();
                break;
            case "+":
                choosePlus();
                break;
            case "=":
                chooseEqual();
                break;
            case ".":
                chooseDecimalSeparator();
                break;
            default: // digits
                chooseDigit(view.getTag().toString());
                break;
        }
    }

    private void setDisplay() {
        textView.setText(display);
    }

    private void setDisplay(String newDisplay) {
        display = newDisplay;
        setDisplay();
    }

    private void setDisplay(double newDisplay) {
        display = String.valueOf(newDisplay).replaceAll("\\.0*$", "");
        setDisplay();
    }

    private void setOperand() {
        if (operandBeingInput) {
            lastOperand = textView.getText().toString();
            calcUL.setOperand(Double.valueOf(lastOperand));
            operandBeingInput = false;
        }
    }

    private void chooseClear() {
        calcUL.clear();
        operandBeingInput = false;
        setDisplay(defaultValue);
    }

    private void chooseDivide() {
        setOperand();
        setDisplay(calcUL.setDivide());
    }

    private void chooseMultiple() {
        setOperand();
        setDisplay(calcUL.setMultiple());
    }

    private void chooseMinus() {
        setOperand();
        setDisplay(calcUL.setMinus());
    }

    private void choosePlus() {
        setOperand();
        setDisplay(calcUL.setPlus());
    }

    private void chooseEqual() {
        // while equal asked without new operand input the last operand (and operation) is re-used
        if (!operandBeingInput && !lastOperand.equals("")) {
            calcUL.setOperand(Double.valueOf(lastOperand));
        } else {
            setOperand();
        }
        setDisplay(calcUL.setEqual());
    }

    private void chooseDecimalSeparator() {
        if (display.lastIndexOf(".") < 0) {
            if (!operandBeingInput) {
                operandBeingInput = true;
                setDisplay(defaultValue + ".");
            } else {
                setDisplay(display + ".");
            }
        }
    }

    private void chooseDigit(String digit) {
        if (!operandBeingInput) {
            operandBeingInput = true;
            setDisplay(digit);
        } else {
            setDisplay(display + digit);
        }
    }
}
