package com.jerome.calcul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final String DEFAULT_VALUE = "0";
    protected static CalcUL calcUL = new CalcUL();
    protected static String display = DEFAULT_VALUE;
    protected static String lastOperand = DEFAULT_VALUE;
    protected static boolean operandBeingInput = false;
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_result);
        setDisplay(display);
        initButtons();
    }

    public void onClick(View view) {
        try {
            switch (view.getTag().toString()) {
                case "C":
                    chooseClear();
                    break;
                case "=":
                    chooseEqual();
                    break;
            }
        } catch (CalcULException e) {
            Log.e("my_error", "division by zero");
            chooseClear();
            setDisplay(getResources().getString(R.string.calc_division_by_zero));
        }
    }

    protected String getDisplay() {
        return display;
    }

    protected void setDisplay(String newDisplay) {
        display = newDisplay;
        setDisplay();
    }

    protected void setDisplay(double newDisplay) {
        display = String.valueOf(newDisplay).replaceAll("\\.0*$", "");
        setDisplay();
    }

    protected void setDisplay() {
        textView.setText(display);
    }

    protected void setOperand() {
        if (operandBeingInput) {
            lastOperand = textView.getText().toString();
            operandBeingInput = false;
        } else if ("".equals(lastOperand)) {
            lastOperand = display;
        }
    }

    protected void setOperand(boolean setFromDisplay) {
        if (setFromDisplay) {
            lastOperand = textView.getText().toString();
            operandBeingInput = false;
        } else {
            setOperand();
        }
    }

    protected void chooseClear() {
        calcUL.clear();
        operandBeingInput = false;
        lastOperand = DEFAULT_VALUE;
        setDisplay(DEFAULT_VALUE);
    }

    private void chooseEqual() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setEqual(Double.valueOf(lastOperand)));
    }

    private void initButtons() {
        int[] my_buttons = {R.id.btn_clear, R.id.btn_equal};
        Button button;
        for (int i : my_buttons) {
            button = (Button) findViewById(i);
            button.setOnClickListener(this);
        }
    }
}
