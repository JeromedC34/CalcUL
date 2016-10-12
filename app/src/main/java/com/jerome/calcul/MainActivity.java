package com.jerome.calcul;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final String DEFAULT_VALUE = "0";
    protected static CalcUL calcUL = new CalcUL();
    protected static String display = DEFAULT_VALUE;
    protected static boolean operandBeingInput = false;
    protected static int themeChosen = 1;
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_result);
        setDisplay(display);
        initButtons();
        chooseTheme(themeChosen);
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
                case "theme1":
                    chooseTheme(1);
                    break;
                case "theme2":
                    chooseTheme(2);
                    break;
                case "theme3":
                    chooseTheme(3);
                    break;
                case "theme4":
                    chooseTheme(4);
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

    protected void setDisplay(double newDisplay) {
        display = String.valueOf(newDisplay).replaceAll("\\.0*$", "");
        setDisplay();
    }

    protected void setDisplay(String newDisplay) {
        display = newDisplay;
        setDisplay();
    }

    protected void setDisplay() {
        textView.setText(display);
    }

    protected void setOperand() {
        if (operandBeingInput) {
            operandBeingInput = false;
        }
    }

    protected void setOperand(boolean setFromDisplay) {
        if (setFromDisplay) {
            operandBeingInput = false;
            calcUL.clear();
        } else {
            setOperand();
        }
    }

    protected void chooseClear() {
        calcUL.clear();
        operandBeingInput = false;
        setDisplay(DEFAULT_VALUE);
    }

    private void chooseEqual() throws CalcULException {
        setOperand();
        setDisplay(calcUL.setEqual(Double.valueOf(display)));
    }

    protected void chooseTheme(int myTheme) {
        int color = 1;
        switch (myTheme) {
            case 1:
                color = ContextCompat.getColor(this, R.color.colorPrimary1);
                break;
            case 2:
                color = ContextCompat.getColor(this, R.color.colorPrimary2);
                break;
            case 3:
                color = ContextCompat.getColor(this, R.color.colorPrimary3);
                break;
            case 4:
                color = ContextCompat.getColor(this, R.color.colorPrimary4);
                break;
        }
        View baseView = findViewById(R.id.activity_main);
        baseView.setBackgroundColor(color);
        DrawerLayout mDrawerLayout;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.closeDrawers();
        themeChosen = myTheme;
    }

    private void initButtons() {
        int[] my_buttons = {R.id.btn_clear, R.id.btn_equal, R.id.btn_theme1, R.id.btn_theme2, R.id.btn_theme3, R.id.btn_theme4};
        Button button;
        for (int i : my_buttons) {
            button = (Button) findViewById(i);
            button.setOnClickListener(this);
        }
    }
}
