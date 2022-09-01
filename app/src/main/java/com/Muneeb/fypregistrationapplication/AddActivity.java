package com.Muneeb.fypregistrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Muneeb.fypregistrationapplication.R;

public class AddActivity extends AppCompatActivity {

    EditText stu_name_input, fat_name_input, major_input, project_input, supervisor_input, email_input, github_input;
    Button add_application_button;

    FYPReg fypReg = new FYPReg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        stu_name_input = findViewById(R.id.stu_name_input);
        fat_name_input = findViewById(R.id.fat_name_input);
        major_input = findViewById(R.id.major_input);
        project_input = findViewById(R.id.project_input);
        supervisor_input = findViewById(R.id.supervisor_input);
        email_input = findViewById(R.id.email_input);
        github_input = findViewById(R.id.github_input);

        add_application_button = findViewById(R.id.update_application_button);

        add_application_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);

                myDB.addApplication(fypReg.setStuName(stu_name_input.getText().toString().trim()),
                        fypReg.setFatName(fat_name_input.getText().toString().trim()),
                        fypReg.setMajor(major_input.getText().toString().trim()),
                        fypReg.setProject(project_input.getText().toString().trim()),
                        fypReg.setSupervisor(supervisor_input.getText().toString().trim()),
                        fypReg.setEmail(email_input.getText().toString().trim()),
                        fypReg.setGitHub(github_input.getText().toString().trim()));


                Intent intent = new Intent(AddActivity.this, ViewActivity.class);
                startActivity(intent);

            }
        });
    }
}