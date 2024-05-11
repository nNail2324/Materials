package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Start_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickButton1(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onClickButton2(View view) {
        startActivity(new Intent(this, List_View.class));
    }

    public void onClickButton3(View view) {
        startActivity(new Intent(this, Recycler_View.class));
    }

    public void onCLickButton4(View view) {
        startActivity(new Intent(this, Sight.class));
    }
}