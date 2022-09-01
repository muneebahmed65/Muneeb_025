package com.Muneeb.fypregistrationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "FYPRegForm.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "fypForm";

    private static final String COLUMN_FORM_NO = "_form_no";
    private static final String COLUMN_STUNAME = "stu_name";
    private static final String COLUMN_FATNAME = "fat_name";
    private static final String COLUMN_MAJOR = "major";
    private static final String COLUMN_PROJECT_TITLE = "project_title";
    private static final String COLUMN_SUPERVISOR = "supervisor";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_GITHUB = "github";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_FORM_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUNAME + " TEXT, " +
                COLUMN_FATNAME + " TEXT, " +
                COLUMN_MAJOR + " TEXT, " +
                COLUMN_PROJECT_TITLE + " TEXT, " +
                COLUMN_SUPERVISOR + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_GITHUB + " TEXT);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }



    void addApplication(String stuName, String fatName, String major, String project_title, String supervisor, String email, String github){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUNAME, stuName);
        cv.put(COLUMN_FATNAME, fatName);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PROJECT_TITLE, project_title);
        cv.put(COLUMN_SUPERVISOR, supervisor);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_GITHUB, github);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed To Insert!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Inserted Successfully!", Toast.LENGTH_SHORT).show();
        }

    }



    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    void updateApplication(String row_id, String stuName, String fatName, String major, String project_title, String supervisor, String email, String github){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUNAME, stuName);
        cv.put(COLUMN_FATNAME, fatName);
        cv.put(COLUMN_MAJOR, major);
        cv.put(COLUMN_PROJECT_TITLE, project_title);
        cv.put(COLUMN_SUPERVISOR, supervisor);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_GITHUB, github);

        long result = db.update(TABLE_NAME, cv, COLUMN_FORM_NO + " =?", new String[] {row_id});
        if(result == -1){
            Toast.makeText(context, "Failed To Update!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }



    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_FORM_NO + " =?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
