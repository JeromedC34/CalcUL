package com.jerome.calcul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String defaultValue = "0";
    private static CalcUL calcUL = new CalcUL();
    private static String display = defaultValue;
    private static String lastOperand1 = "";
    private static String lastOperand2 = "";
    private static String lastOperation = "";
    private static String nextOperation = "";
    private static boolean operandBeingInput = true;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_result);
        setDisplay(display);
    }

    public void manageAction(View view) {
        doAction(view.getTag().toString());
    }

    private void setDisplay() {
        textView.setText(display);
    }

    private void setDisplay(String newDisplay) {
        display = newDisplay.replaceAll("^0*([0-9]+)([\\.0-9]+)", "$1$2");
        setDisplay();
    }

    private void setDisplay(double newDisplay) {
        display = String.valueOf(newDisplay).replaceAll("\\.0*$", "");
        setDisplay();
    }

    private void doAction(String myTag) {
        switch (myTag) {
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
                chooseDigit(myTag);
                break;
        }
    }

    private void chooseClear() {
        operandBeingInput = true;
        lastOperand1 = "";
        lastOperand2 = "";
        lastOperation = "";
        nextOperation = "";
        setDisplay(defaultValue);
    }

    private void chooseDivide() {
        chooseEqual();
        nextOperation = "/";
    }

    private void chooseMultiple() {
        chooseEqual();
        nextOperation = "*";
    }

    private void chooseMinus() {
        chooseEqual();
        nextOperation = "-";
    }

    private void choosePlus() {
        chooseEqual();
        nextOperation = "+";
    }

    private void setOperand() {
        if (operandBeingInput) {
            if (lastOperand1.equals("")) {
                lastOperand1 = textView.getText().toString();
            } else {
                lastOperand2 = textView.getText().toString();
            }
            operandBeingInput = false;
        }
    }

    private void chooseEqual() {
        String operation = "";
        if (nextOperation.equals("")) {
            if (!lastOperation.equals("")) { // equal input several times
                operation = lastOperation;
            } else { // nothing to compute
                setOperand();
            }
        } else {
            setOperand();
            operation = nextOperation;
        }
        if (!operation.equals("") && !lastOperand1.equals("") && !lastOperand2.equals("")) {
            switch (operation) {
                case "+":
                    setDisplay(calcUL.doPlus(Double.valueOf(lastOperand1), Double.valueOf(lastOperand2)));
                    break;
                case "-":
                    setDisplay(calcUL.doMinus(Double.valueOf(lastOperand1), Double.valueOf(lastOperand2)));
                    break;
                case "*":
                    setDisplay(calcUL.doMultiple(Double.valueOf(lastOperand1), Double.valueOf(lastOperand2)));
                    break;
                case "/":
                    setDisplay(calcUL.doDivide(Double.valueOf(lastOperand1), Double.valueOf(lastOperand2)));
                    break;
            }
            lastOperand1 = display;
            lastOperation = operation;
            nextOperation = "";
        }
    }

    private void chooseDecimalSeparator() {
        if (operandBeingInput) {
            if (display.lastIndexOf(".") < 0) {
                setDisplay(display + ".");
            }
        } else {
            operandBeingInput = true;
            setDisplay(defaultValue + ".");
        }
    }

    private void chooseDigit(String digit) {
        if (!operandBeingInput) {
            operandBeingInput = true;
            setDisplay(digit);
        } else {
            if (display.equals(defaultValue)) {
                setDisplay(digit);
            } else {
                setDisplay(display + digit);
            }
        }
    }
}
