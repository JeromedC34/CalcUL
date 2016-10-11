package com.jerome.calcul;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NormalFragment extends Fragment implements View.OnClickListener {
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_normal, container, false);
        mainActivity = ((MainActivity) getActivity());
        initButtons(view);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onClick(View view) {
        try {
            switch (view.getTag().toString()) {
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
                case ".":
                    chooseDecimalSeparator();
                    break;
                default: // digits
                    chooseDigit(view.getTag().toString());
                    break;
            }
        } catch (CalcULException e) {
            Log.e("my_error", "division by zero");
            mainActivity.chooseClear();
            mainActivity.setDisplay(getResources().getString(R.string.calc_division_by_zero));
        }

    }

    private void chooseDivide() throws CalcULException {
        mainActivity.setOperand();
        mainActivity.setDisplay(mainActivity.calcUL.setDivide(Double.valueOf(mainActivity.display)));
    }

    private void chooseMultiple() throws CalcULException {
        mainActivity.setOperand();
        mainActivity.setDisplay(mainActivity.calcUL.setMultiple(Double.valueOf(mainActivity.display)));
    }

    private void chooseMinus() throws CalcULException {
        mainActivity.setOperand();
        mainActivity.setDisplay(mainActivity.calcUL.setMinus(Double.valueOf(mainActivity.display)));
    }

    private void choosePlus() throws CalcULException {
        mainActivity.setOperand();
        mainActivity.setDisplay(mainActivity.calcUL.setPlus(Double.valueOf(mainActivity.display)));
    }

    private void chooseDecimalSeparator() {
        if (mainActivity.display.lastIndexOf('.') < 0) {
            if (!mainActivity.operandBeingInput) {
                mainActivity.operandBeingInput = true;
                mainActivity.setDisplay(mainActivity.DEFAULT_VALUE + ".");
            } else {
                mainActivity.setDisplay(mainActivity.display + ".");
            }
        }
    }

    private void chooseDigit(String digit) {
        if (!mainActivity.operandBeingInput) {
            mainActivity.operandBeingInput = true;
            mainActivity.setDisplay(digit);
        } else {
            mainActivity.setDisplay(mainActivity.display + digit);
        }
    }

    private void initButtons(View view) {
        int[] my_buttons = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_dot, R.id.btn_divide, R.id.btn_multiple, R.id.btn_minus, R.id.btn_plus};
        Button button;
        for (int i : my_buttons) {
            button = (Button) view.findViewById(i);
            button.setOnClickListener(this);
        }
    }
}
