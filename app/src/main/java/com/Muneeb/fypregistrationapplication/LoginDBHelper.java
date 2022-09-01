package com.Muneeb.fypregistrationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDBHelper extends SQLiteOpenHelper {

    private static final String LOGIN_DATABASE_NAME = "Login.db";
    private static final int LOGIN_DATABASE_VERSION = 1;

    public LoginDBHelper(@Nullable Context context) {
        super(context, LOGIN_DATABASE_NAME, null, LOGIN_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS users");

    }


    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("username", username);
        cv.put("password", password);

        long result = db.insert("users",null, cv);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkUsername(String username){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ?", new String[] {username});

        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[] {username, password});

        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
}
