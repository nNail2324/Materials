package com.example.lr2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView VarA, VarB, result;

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
        result = findViewById(R.id.tv1);

        double numberA = Double.parseDouble(VarA.getText().toString());
        double numberB = Double.parseDouble(VarB.getText().toString());

        String X1 = String.format("%.3f", numberB/numberA);
        @SuppressLint("DefaultLocale") String X2 = String.format("%.3f", -numberB/numberA);

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

    public void onClickBackResult(View view) {
        Intent intent_res = new Intent();

        intent_res.putExtra("result", result.getText());
        intent_res.putExtra("name", "Результат");
        setResult(RESULT_OK, intent_res);
        finish();
    }
}