package com.example.coursework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickUserLogin(View view) {
        UserLogin userLogin = new UserLogin();
        FragmentTransaction loginTransaction = getSupportFragmentManager().beginTransaction();
        loginTransaction.replace(R.id.LoginFragment, userLogin);
        loginTransaction.commit();
    }

    public void onClickUserSignUp(View view) {
        UserSignUp userSignUp = new UserSignUp();
        FragmentTransaction signUpTransaction = getSupportFragmentManager().beginTransaction();
        signUpTransaction.replace(R.id.LoginFragment, userSignUp);
        signUpTransaction.commit();
    }
}