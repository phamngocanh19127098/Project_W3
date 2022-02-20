package com.example.myapplication.project_week_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername,txtPassword, txtRetype,txtBirthdate;
    Button btnSelect,btnReset,btnSignup;
    RadioButton rdMale;
    RadioButton rdFemale;
    CheckBox ckTennis,ckFutbal,ckOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = (EditText) this.findViewById(R.id.txtUsername);
        txtPassword = (EditText) this.findViewById(R.id.txtPassword);
        txtRetype = (EditText) this.findViewById(R.id.txtRetype);
        txtBirthdate = (EditText) this.findViewById(R.id.txtBirthdate);
        rdFemale = (RadioButton) this.findViewById(R.id.rdFemale) ;
        rdMale = (RadioButton) this.findViewById(R.id.rdMale);
        ckTennis = (CheckBox) this.findViewById(R.id.ckTennis);
        ckOthers = (CheckBox) this.findViewById(R.id.ckOthers);
        ckFutbal = (CheckBox) this.findViewById(R.id.ckFutbal);
        btnReset = (Button) this.findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtRetype.setText("");
                txtBirthdate.setText("");
                
                rdMale.clearAnimation();
                ckTennis.clearAnimation();
                ckFutbal.clearAnimation();
                ckOthers.clearAnimation();
            }
        });
    }
}