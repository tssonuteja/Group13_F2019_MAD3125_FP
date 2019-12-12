package com.example.group13_f2019_mad3125_fp.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group13_f2019_mad3125_fp.Preference;
import com.example.group13_f2019_mad3125_fp.R;

import static android.text.TextUtils.isEmpty;

public class LoginActivity extends AppCompatActivity {

    private String username, password;
    EditText et_email, et_password;
    Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preference = new Preference(this);

        username = "user@employee.com";
        password = "s3cr3t";

        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
    }

    public void onLoginClick(View view){
        String sEmail = et_email.getText().toString();
        String sPswd = et_password.getText().toString();
        if (isEmpty(sEmail) || isEmpty(sPswd)){
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()){
                et_email.setError("Invalid email");
            } else {
                if (sEmail.equals(username) && sPswd.equals(password)){
                    loginSuccess();
                } else {
                    Toast.makeText(this, "Invalid email/password", Toast.LENGTH_SHORT).show();
                    et_email.requestFocus();
                }
            }
        }

    }

    private void loginSuccess() {

        preference.put("isLoggedIn", true);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
