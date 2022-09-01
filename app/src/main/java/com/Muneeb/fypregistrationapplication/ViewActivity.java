package com.Muneeb.fypregistrationapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.Muneeb.fypregistrationapplication.R;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> form_no, stu_name, fat_name, major, project, supervisor, email, github;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });


        myDB = new MyDatabaseHelper(ViewActivity.this);
        form_no = new ArrayList<>();
        stu_name = new ArrayList<>();
        fat_name = new ArrayList<>();
        major = new ArrayList<>();
        project = new ArrayList<>();
        supervisor = new ArrayList<>();
        email = new ArrayList<>();
        github = new ArrayList<>();


        storeDataInArrays();

        customAdapter = new CustomAdapter(ViewActivity.this, this, form_no, stu_name, fat_name, major, project, supervisor, email, github);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewActivity.this));
    }



    void storeDataInArrays(){

        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data Found!", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                form_no.add(cursor.getString(0));
                stu_name.add(cursor.getString(1));
                fat_name.add(cursor.getString(2));
                major.add(cursor.getString(3));
                project.add(cursor.getString(4));
                supervisor.add(cursor.getString(5));
                email.add(cursor.getString(6));
                github.add(cursor.getString(7));
            }
        }
    }
}