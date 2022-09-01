package com.Muneeb.fypregistrationapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Muneeb.fypregistrationapplication.R;

public class UpdateActivity extends AppCompatActivity {

    EditText stu_name_input, fat_name_input, major_input, project_input, supervisor_input, email_input, github_input;
    Button update_application_button, delete_application_button;

    String formNo, stuName, fatName, major, project, supervisor, email, github;

    FYPReg fypReg = new FYPReg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        stu_name_input = findViewById(R.id.stu_name_input2);
        fat_name_input = findViewById(R.id.fat_name_input2);
        major_input = findViewById(R.id.major_input2);
        project_input = findViewById(R.id.project_input2);
        supervisor_input = findViewById(R.id.supervisor_input2);
        email_input = findViewById(R.id.email_input2);
        github_input = findViewById(R.id.github_input2);

        update_application_button = findViewById(R.id.update_application_button);
        delete_application_button = findViewById(R.id.delete_application_button);


        getAndSetIntentData();


        update_application_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);

                myDB.updateApplication(formNo, fypReg.setStuName(stu_name_input.getText().toString().trim()),
                        fypReg.setFatName(fat_name_input.getText().toString().trim()),
                        fypReg.setMajor(major_input.getText().toString().trim()),
                        fypReg.setProject(project_input.getText().toString().trim()),
                        fypReg.setSupervisor(supervisor_input.getText().toString().trim()),
                        fypReg.setEmail(email_input.getText().toString().trim()),
                        fypReg.setGitHub(github_input.getText().toString().trim()));

            }
        });



        delete_application_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirmDialog();

            }
        });
    }


    void getAndSetIntentData(){

        if (getIntent().hasExtra("form_no") && getIntent().hasExtra("stu_name") && getIntent().hasExtra("fat_name") &&
                getIntent().hasExtra("major") && getIntent().hasExtra("project") && getIntent().hasExtra("supervisor") &&
                getIntent().hasExtra("email") && getIntent().hasExtra("github")){

            // Getting data form intent

            formNo = getIntent().getStringExtra("form_no");
            stuName = getIntent().getStringExtra("stu_name");
            fatName = getIntent().getStringExtra("fat_name");
            major = getIntent().getStringExtra("major");
            project = getIntent().getStringExtra("project");
            supervisor = getIntent().getStringExtra("supervisor");
            email = getIntent().getStringExtra("email");
            github = getIntent().getStringExtra("github");

            // Setting Intent Data

            stu_name_input.setText(stuName);
            fat_name_input.setText(fatName);
            major_input.setText(major);
            project_input.setText(project);
            supervisor_input.setText(supervisor);
            email_input.setText(email);
            github_input.setText(github);
        }
    }



    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + stuName + " ?");
        builder.setMessage("Are you sure you want to delete " + stuName + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(formNo);

                Intent intent = new Intent(UpdateActivity.this, ViewActivity.class);
                startActivity(intent);

                //finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}