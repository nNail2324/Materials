package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class City extends AppCompatActivity {
    TextView textView2, textView1;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        getInfo();
    }

    public void getInfo() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("position", 0);
        String name = intent.getStringExtra("city");
        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        switch (i){
            case 0: text = getString(R.string.Виндхук);break;
            case 1: text = getString(R.string.Рунду);break;
            case 2: text = getString(R.string.Уолфиш);break;
            case 3: text = getString(R.string.Ошакати);break;
            case 4: text = getString(R.string.Свакопмунд);break;
            case 5: text = getString(R.string.Хрутфонтейн);break;
            case 6: text = getString(R.string.Катима);break;
            case 7: text = getString(R.string.Окаханджа);break;
            case 8: text = getString(R.string.Очиваронго);break;
            case 9: text = getString(R.string.Рехобот);break;
        }

        textView1.setText(name);
        textView2.setText(text);
    }
}