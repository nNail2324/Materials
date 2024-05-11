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

public class Output extends Fragment {
    EditText date;
    Button button_search;
    TextView textDate, textDay;
    DatabaseManager databaseManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_output, container, false);

        textDate = view.findViewById(R.id.text_date);
        textDay = view.findViewById(R.id.text_day);
        button_search = view.findViewById(R.id.button_output);
        date = view.findViewById(R.id.edit_output);

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

                text = date.getText().toString();
                if (cursor.moveToFirst()) {
                    int date = cursor.getColumnIndex(Database.DATE);
                    int name = cursor.getColumnIndex(Database.SUBJECT_NAME);
                    int teacher = cursor.getColumnIndex(Database.TEACHER);
                    int classroom = cursor.getColumnIndex(Database.CLASSROOM);

                    do {
                        String cursorDate = cursor.getString(date);

                        if (cursorDate.equals(text)) {
                            textDay.append(cursor.getString(name) + "\n");
                            textDay.append(cursor.getString(teacher) + " - ауд. ");
                            textDay.append(cursor.getString(classroom) + "\n\n");
                        }
                    } while (cursor.moveToNext());
                    textDate.setText(text);
                }
            }
        });

        return view;
    }


}