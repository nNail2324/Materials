package com.example.lr2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Solution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
    }

    public void onClickTransfer(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText varA = findViewById(R.id.varA);
        EditText varB = findViewById(R.id.varB);

        intent.putExtra("varA", varA.getText().toString());
        intent.putExtra("varB", varB.getText().toString());
        startActivity(intent);
    }
}