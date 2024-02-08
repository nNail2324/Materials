package com.example.lr2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView VarA, VarB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        VarA = findViewById(R.id.varA);
        VarB = findViewById(R.id.varB);
        VarA.setText(intent.getStringExtra("varA"));
        VarB.setText(intent.getStringExtra("varB"));
    }

    public void change(View view) {
        TextView result = findViewById(R.id.tv1);

        String textA = VarA.getText().toString();
        String textB = VarB.getText().toString();
        double numberA = 0;
        double numberB = 0;

        if (!(textA.isEmpty() && textB.isEmpty())) {
            try {
                numberA = Double.parseDouble(textA);
                numberB = Double.parseDouble(textB);
            } catch (NumberFormatException e) {
                result.setText("Введите числовое значение!");
                e.printStackTrace();
            }
        }

        String X1 = String.format("%.3f", numberB/numberA);
        String X2 = String.format("%.3f", -numberB/numberA);

        if (numberA > 0 && numberB > 0) {
            result.setText("Нет решений");

        } else if (numberA > 0 && numberB < 0) {
            result.setText(X1 + " < x < " + X2);

        } else if (numberA < 0 && numberB > 0) {
            result.setText("x < " + X2 + " или x > " + X1);

        } else{
            result.setText("Верно для всех x");
        }

    }
}