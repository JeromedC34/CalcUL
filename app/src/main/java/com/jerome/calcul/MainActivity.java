package com.jerome.calcul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected CalcUL calcUL = new CalcUL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_result);
        textView.setText(calcUL.getResult());
    }
    public void manageAction(View view) {
        TextView textView = (TextView) findViewById(R.id.text_result);
        textView.setText(calcUL.manageAction(view.getTag().toString()));
    }
}
