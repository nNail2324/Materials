package com.example.schedule;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search extends Fragment {
    DatabaseManager databaseManager;
    TextView textSearch;
    Button button_search;
    EditText element;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        textSearch = view.findViewById(R.id.text_search);
        button_search = view.findViewById(R.id.button_search);
        element = view.findViewById(R.id.edit_search);

        databaseManager = new DatabaseManager(getContext());
        try {
            databaseManager.open();
            Log.d("Database", "open");
        } catch (Exception e) {
            Log.d("Database", "error");
            e.printStackTrace();
        }

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                Cursor cursor = databaseManager.fetch();

                text = element.getText().toString();
                if (cursor.moveToFirst()) {
                    int date = cursor.getColumnIndex(Database.DATE);
                    int name = cursor.getColumnIndex(Database.SUBJECT_NAME);
                    int teacher = cursor.getColumnIndex(Database.TEACHER);
                    int classroom = cursor.getColumnIndex(Database.CLASSROOM);

                    do {
                        if (cursor.getString(name).equals(text) | cursor.getString(teacher).equals(text) | cursor.getString(classroom).equals(text)) {
                            textSearch.append(cursor.getString(date) + "\n");
                            textSearch.append(cursor.getString(name) + "\n");
                            textSearch.append(cursor.getString(teacher) + " - ауд. ");
                            textSearch.append(cursor.getString(classroom) + "\n\n");
                        }
                    } while (cursor.moveToNext());
                }
            }
        });

        return view;
    }
}