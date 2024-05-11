package com.example.schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Input extends Fragment {
    DatabaseManager databaseManager;
    EditText editDate, editTeacher, editSubject, editClassroom;
    Button button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container, false);

        editDate = view.findViewById(R.id.edit_date);
        editTeacher = view.findViewById(R.id.edit_teacher);
        editSubject = view.findViewById(R.id.edit_subject);
        editClassroom = view.findViewById(R.id.edit_classroom);
        button = view.findViewById(R.id.button_save);

        databaseManager = new DatabaseManager(getContext());
        try {
            databaseManager.open();
            Log.d("Database", "open");
        } catch (Exception e) {
            Log.d("Database", "error");
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.insert(editSubject.getText().toString(), editTeacher.getText().toString(), editClassroom.getText().toString(), editDate.getText().toString());
            }
        });

        return view;
    }

}