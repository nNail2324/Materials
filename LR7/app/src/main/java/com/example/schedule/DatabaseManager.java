package com.example.schedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import java.sql.SQLDataException;

public class DatabaseManager {
    private Database database;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context context) {
        this.context = context;
        database = new Database(context);
    }

    public void open() {
        sqLiteDatabase = database.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public void insert(String subject, String teacher, String classroom, String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Database.SUBJECT_NAME, subject);
        contentValues.put(Database.TEACHER, teacher);
        contentValues.put(Database.CLASSROOM, classroom);
        contentValues.put(Database.DATE, date);
        sqLiteDatabase.insert(Database.TABLE_NAME, null, contentValues);
    }

    public Cursor fetch() {
        String[] columns = new String[] {Database.ID, Database.SUBJECT_NAME, Database.TEACHER, Database.CLASSROOM, Database.DATE};
        Cursor cursor = sqLiteDatabase.query(Database.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
