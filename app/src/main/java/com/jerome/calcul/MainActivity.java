package com.jerome.calcul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DEFAULT_VALUE = "0";
    private static CalcUL calcUL = new CalcUL();
    private static String display = DEFAULT_VALUE;
    private static String lastOperand = DEFAULT_VALUE;
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
        try {
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
        } catch (CalcULException e) {
            Log.e("my_error", "division by zero");
            chooseClear();
            setDisplay(getResources().getString(R.string.calc_division_by_zero));
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
            operandBeingInput = false;
        } else if ("".equals(lastOperand)) {
            lastOperand = display;
        }
    }

    private void chooseClear() {
        calcUL.clear();
        operandBeingInput = false;
        lastOperand = "0";
        setDisplay(DEFAULT_VALUE);
    }

    private void chooseDivide() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setDivide(Double.valueOf(lastOperand)));
    }

    private void chooseMultiple() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setMultiple(Double.valueOf(lastOperand)));
    }

    private void chooseMinus() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setMinus(Double.valueOf(lastOperand)));
    }

    private void choosePlus() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setPlus(Double.valueOf(lastOperand)));
    }

    private void chooseEqual() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setEqual(Double.valueOf(lastOperand)));
        lastOperand = "";
    }

    private void chooseDecimalSeparator() {
        if (display.lastIndexOf('.') < 0) {
            if (!operandBeingInput) {
                operandBeingInput = true;
                setDisplay(DEFAULT_VALUE + ".");
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
