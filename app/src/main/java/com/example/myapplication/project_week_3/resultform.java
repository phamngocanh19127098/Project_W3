package com.example.myapplication.project_week_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultform extends Activity {
    TextView etUsername,etPassword, etGender,etBirthdate,etHobbies;
    Button Exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultform);
        Exit = (Button) findViewById(R.id.btnExit);
        etUsername = (TextView) findViewById(R.id.etUsername);
        etPassword = (TextView) findViewById(R.id.etPassword);
        etGender = (TextView) findViewById(R.id.etGender);
        etBirthdate = (TextView) findViewById(R.id.etBirthdate);
        etHobbies= (TextView) findViewById(R.id.etHobbies);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            etUsername.setText(extras.getString("username"));
            etPassword.setText(extras.getString("password"));
            etBirthdate.setText(extras.getString("birthdate"));
            etGender.setText(extras.getString("gender"));
            etHobbies.setText(extras.getString("hobbies"));
        }
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}