package com.example.lr2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickMath(View view) {
        startActivity(new Intent(StartActivity.this, Solution.class));
    }

    public void onClickAbout(View view) {
        startActivity(new Intent(StartActivity.this, About.class));
    }

    public void onClickExit(View view) {
        this.finish();
    }
}