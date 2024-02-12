package com.example.lr2_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Solution extends AppCompatActivity {
    TextView result;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
        result = findViewById(R.id.tv_res);
        name = findViewById(R.id.tv2);
    }

    public void onClickTransfer(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText varA = findViewById(R.id.varA);
        EditText varB = findViewById(R.id.varB);

        intent.putExtra("varA", varA.getText().toString());
        intent.putExtra("varB", varB.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                result.setText(data.getStringExtra("result"));
                name.setText(data.getStringExtra("name"));
            }
        }
    }
}