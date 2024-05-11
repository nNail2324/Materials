package com.example.coursework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    static final String USER_TABLE = "User";
    static final String USER_ID = "UserId";
    static final String USER_SURNAME = "Surname";
    static final String USER_NAME = "Name";
    static final String USER_PHONE_NUMBER = "Phone_number";
    static final String USER_EMAIL = "Email";
    static final String USER_PASSWORD = "Password";
    static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS" + USER_TABLE + "(" + USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_SURNAME + "text not null, "
            + USER_NAME + "TEXT NOT NULL, " + USER_PHONE_NUMBER + "TEXT NOT NULL, " + USER_EMAIL + "TEXT NOT NULL, " + USER_PASSWORD + "TEXT NOT NULL);";
    static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS";
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_USER);
        onCreate(db);
    }
}
