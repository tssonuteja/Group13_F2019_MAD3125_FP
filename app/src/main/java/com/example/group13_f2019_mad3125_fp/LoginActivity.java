package com.example.group13_f2019_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        Name = (EditText) findViewById(R.id.et_email);
        Password = (EditText) findViewById(R.id.et_password);
        //Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btn_login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());

            }
        });
    }




        private void validate(String userName, String userPassword) {
            if ((userName.equals("Admin")) && (userPassword.equals("1234"))) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }


            if(userName.isEmpty() && userPassword.equals("1234"))
            {
                Name.setError("empty");
                //Info.setText("Username is empty");
            }
            else if(userName.equals("Admin") && userPassword.isEmpty()) {
                Password.setError("empty");
               // Info.setText("Password is empty");
            }

            else if(userName.equals("Admin") && userPassword!="1234"){
                Password.setError("invalid password");
                //Info.setText("Invalid password");
            }
            else if(userName!="Admin"&& userPassword.equals("1234")){
                Name.setError("invalid username");
               // Info.setText("Invalid username");
            }


            else if(userName!="Admin" || userPassword!="1234"){

                Name.setError("invalid username");
                Password.setError("invalid password");

                //Info.setError("invalid credentials");
               // Info.setText("invalid credentials");



            }

            else{
                //Info.setText("Success");
            }


        }
}



