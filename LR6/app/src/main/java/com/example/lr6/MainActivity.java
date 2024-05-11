package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] cities = getResources().getStringArray(R.array.cities);
        ArrayAdapter Namibia = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);

        setListAdapter(Namibia);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, City.class);

        intent.putExtra("position", position);
        intent.putExtra("city", l.getItemAtPosition(position).toString());
        startActivity(intent);
    }
}