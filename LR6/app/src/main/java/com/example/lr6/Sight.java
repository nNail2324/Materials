package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Sight extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    String[] cities, sight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lv);
        cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Change(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void Change(int index) {
        switch (index) {
            case 0: sight = getResources().getStringArray(R.array.Виндхук); break;
            case 1: sight = getResources().getStringArray(R.array.Рунду); break;
            case 2: sight = getResources().getStringArray(R.array.Уолфиш_Бей); break;
            case 3: sight = getResources().getStringArray(R.array.Ошакати); break;
            case 4: sight = getResources().getStringArray(R.array.Свакопмунд); break;
            case 5: sight = getResources().getStringArray(R.array.Хрутфонтейн); break;
            case 6: sight = getResources().getStringArray(R.array.Катима_Мулило); break;
            case 7: sight = getResources().getStringArray(R.array.Окаханджа); break;
            case 8: sight = getResources().getStringArray(R.array.Очиваронго); break;
            case 9: sight = getResources().getStringArray(R.array.Рехобот); break;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sight);
        listView.setAdapter(arrayAdapter);
    }
}