package com.jerome.calcul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected CalcUL calcUL = new CalcUL();
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_result);
        textView.setText(calcUL.getDisplay());
    }
    public void manageAction(View view) {

        textView.setText(calcUL.manageAction(view.getTag().toString()));
    }
}
