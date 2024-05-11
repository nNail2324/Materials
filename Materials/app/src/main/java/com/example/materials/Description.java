package com.example.materials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    String text, name;
    TextView textName, textDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getInfo();
    }

    public void getInfo() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("position", 0);
        textDescription = findViewById(R.id.description);
        textName = findViewById(R.id.name);

        switch (i){
            case 0: text = getString(R.string.cement); name = "Цемент"; break;
            case 1: text = getString(R.string.brick); name = "Кирпич"; break;
            case 2: text = getString(R.string.sand); name = "Песок"; break;
            case 3: text = getString(R.string.construction); name = "Арматура"; break;
            case 4: text = getString(R.string.tubes); name = "Труба стальная"; break;
            case 5: text = getString(R.string.pipe); name = "Труба водогазопроводная"; break;
            case 6: text = getString(R.string.corner); name = "Уголок"; break;
        }

        textName.setText(name);
        textDescription.setText(text);
    }
}