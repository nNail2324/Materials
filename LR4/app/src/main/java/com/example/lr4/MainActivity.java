package com.example.lr4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTask1(View view) {
        startActivity(new Intent(this, Task1.class));
    }

    public void onTask2(View view) {
        startActivity(new Intent(this, Task2.class));
    }

    public void onTask3(View view) {
        startActivity(new Intent(this, Task3.class));
    }
}