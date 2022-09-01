package com.Muneeb.fypregistrationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Muneeb.fypregistrationapplication.R;

public class SignupActivity extends AppCompatActivity {

    EditText signup_username_input, signup_password_input, signup_repassword_input;
    Button login_button2, signup_button2;

    LoginDBHelper loginDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signup_username_input = findViewById(R.id.signup_username_input);
        signup_password_input = findViewById(R.id.signup_password_input);
        signup_repassword_input = findViewById(R.id.signup_repassword_input);
        login_button2 = findViewById(R.id.login_button2);
        signup_button2 = findViewById(R.id.signup_button2);

        loginDBHelper = new LoginDBHelper(this);


        signup_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = signup_username_input.getText().toString();
                String password = signup_password_input.getText().toString();
                String repassword = signup_repassword_input.getText().toString();

                if (user.equals("") || password.equals("") || repassword.equals("")){
                    Toast.makeText(SignupActivity.this, "Must Fill All Fields!", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (password.equals(repassword)){
                        Boolean checkUser = loginDBHelper.checkUsername(user);
                        if (checkUser == false){
                            Boolean insert = loginDBHelper.insertData(user, password);
                            if (insert == true){
                                Toast.makeText(SignupActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(SignupActivity.this, "Failed To Register!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignupActivity.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Passwords Not Matching!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        login_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}