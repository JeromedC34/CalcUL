package com.jerome.calcul;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ScientificFragment extends Fragment implements View.OnClickListener {
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientific, container, false);
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
                case "sin":
                    chooseSin();
                    break;
                case "cos":
                    chooseCos();
                    break;
                case "tan":
                    chooseTan();
                    break;
                case "x_pow_2":
                    chooseXPow2();
                    break;
                case "sin_inv":
                    chooseSinInv();
                    break;
                case "cos_inv":
                    chooseCosInv();
                    break;
                case "tan_inv":
                    chooseTanInv();
                    break;
                case "x_pow_3":
                    chooseXPow3();
                    break;
                case "e_pow_x":
                    chooseEPowX();
                    break;
                case "10_pow_x":
                    choose10PowX();
                    break;
                case "1_div_x":
                    choose1DivX();
                    break;
                case "x_pow_y":
                    chooseXPowY();
                    break;
                case "ln":
                    chooseLn();
                    break;
                case "log":
                    chooseLog();
                    break;
                case "sqrt":
                    chooseSqrt();
                    break;
                case "plus_minus":
                    choosePlusMinus();
                    break;
            }
        } catch (CalcULException e) {
            Log.e("my_error", "division by zero");
            mainActivity.chooseClear();
            mainActivity.setDisplay(getResources().getString(R.string.calc_division_by_zero));
        }
    }

    private void chooseXPowY() throws CalcULException {
        mainActivity.setOperand();
        mainActivity.setDisplay(mainActivity.calcUL.setXPowY(Double.valueOf(mainActivity.display)));
    }

    private void chooseSin() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setSin(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseCos() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setCos(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseTan() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setTan(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseXPow2() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setXPow2(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseSinInv() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setSinInv(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseCosInv() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setCosInv(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseTanInv() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setTanInv(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseXPow3() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setXPow3(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseEPowX() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setEPowX(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void choose10PowX() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.set10PowX(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void choose1DivX() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.set1DivX(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseLn() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setLn(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseLog() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setLog(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void chooseSqrt() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setSqrt(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void choosePlusMinus() throws CalcULException {
        mainActivity.setDisplay(mainActivity.calcUL.setPlusMinus(Double.valueOf(mainActivity.getDisplay())));
        mainActivity.setOperand(true);
    }

    private void initButtons(View view) {
        int[] my_buttons = {R.id.btn_sin, R.id.btn_cos, R.id.btn_tan, R.id.btn_x_pow_2, R.id.btn_sin_inv, R.id.btn_cos_inv, R.id.btn_tan_inv, R.id.btn_x_pow_3, R.id.btn_e_pow_x, R.id.btn_10_pow_x, R.id.btn_1_div_x, R.id.btn_x_pow_y, R.id.btn_ln, R.id.btn_log, R.id.btn_sqrt, R.id.btn_plus_minus};
        Button button;
        for (int i : my_buttons) {
            button = (Button) view.findViewById(i);
            button.setOnClickListener(this);
        }
    }
}
