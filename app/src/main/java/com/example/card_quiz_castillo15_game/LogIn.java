package com.example.card_quiz_castillo15_game;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogIn extends AppCompatActivity {

    String Email, Password;
    EditText newEmail, newPassword;
    Button enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        //using getIntent to pull variables from Register class
        Email = getIntent().getExtras().getString("EMAIL");
        Password = getIntent().getExtras().getString("PASSWORD");


        newEmail = (EditText) findViewById(R.id.email);
        newPassword = (EditText) findViewById(R.id.password);
        enter = (Button) findViewById(R.id.btn_log);

    }




    public void logEnter(View view) {
        String logEmail = newEmail.getText().toString();
        String logPassword = newPassword.getText().toString();

        //If email and password from register match the email and password from login
        if (Email.equals(logEmail) && Password.equals(logPassword)){
            startActivity(new Intent(LogIn.this, QuizInstruction.class));

        }

        //If email and password from register don't match the email and password from login
        else{
            Toast.makeText(this,"Wrong Username or password",Toast.LENGTH_LONG).show();
        }

    }
}


