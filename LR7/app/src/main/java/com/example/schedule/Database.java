package com.example.schedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    static final String TABLE_NAME = "Schedule";
    static final String ID = "ScheduleId";
    static final String SUBJECT_NAME = "Subject";
    static final String TEACHER = "Teacher";
    static final String CLASSROOM = "Classroom";
    static final String DATE = "Date";
    static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT_NAME + " TEXT NOT NULL, "
            + TEACHER + " TEXT NOT NULL, " + CLASSROOM + " TEXT NOT NULL, " + DATE + " TEXT NOT NULL);";
    static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    public Database(Context context) {
        super(context, "schedule.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Databse", "create");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_NAME);
    }
}
