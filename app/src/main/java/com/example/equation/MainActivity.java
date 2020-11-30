package com.example.equation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    EditText ed1, ed2, ed3;
    TextView text1, text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.ans1);
        text2 = findViewById(R.id.ans2);
        btn = findViewById(R.id.btn);
        ed1 = findViewById(R.id.a);
        ed2 = findViewById(R.id.b);
        ed3 = findViewById(R.id.c);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s1 = ed1.getText().toString();
        String s2 = ed2.getText().toString();
        String s3 = ed3.getText().toString();
        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = Double.parseDouble(s3);
        if (a == 0) {
            if ((b == 0) && (c == 0)) {
                text1.setText("R");
                text2.setText("");
            } else {
                double x = -c / b;
                text1.setText(String.valueOf(x));
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                text1.setText("no answer");
            }
            else if (d == 0){
                double x = -b / (2 * a);
                text1.setText(String.valueOf(x));
            }
            else{
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                text1.setText(String.valueOf(x1));
                text2.setText(String.valueOf(x2));
            }
        }
    }
}