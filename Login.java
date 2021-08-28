package com.example.ilovebooksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email, pass, Password, Name;
    Button login, Login;
    TextView btn, Info;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.pass);
        Login = (Button) findViewById(R.id.Login);

        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        login = findViewById(R.id.Login);
        btn = findViewById(R.id.btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }

        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(Login.this, Register.class);
                startActivity(R);
                finish();
            }
        });

    }
    //Create the Validate Function
    private void validate(String userName, String userPassword){
        if((userName.equals("Waseem@gmail.com")) &&
                (userPassword.equals("Was1"))) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else {
            counter--;

            Info.setText("No of attempts remaining:" + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}