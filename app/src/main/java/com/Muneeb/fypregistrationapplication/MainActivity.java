package com.Muneeb.fypregistrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Muneeb.fypregistrationapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText login_username_input, login_password_input;
    Button login_button, signup_button;

    LoginDBHelper loginDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_username_input = findViewById(R.id.signup_username_input);
        login_password_input = findViewById(R.id.signup_password_input);
        login_button = findViewById(R.id.signup_button2);
        signup_button = findViewById(R.id.login_button2);
        loginDBHelper = new LoginDBHelper(this);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = login_username_input.getText().toString();
                String password = login_password_input.getText().toString();

                if (user.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "All Fields Must Be Filled!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUserPassword = loginDBHelper.checkUsernamePassword(user, password);
                    if (checkUserPassword == true){
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Wrong Username Or Password!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);

            }
        });


    }
}