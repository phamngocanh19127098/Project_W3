package com.example.myapplication.project_week_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class registerform extends Activity {
    EditText txtUsername,txtPassword, txtRetype,txtBirthdate;
    Button btnSelect,btnReset,btnSignup;
    RadioButton rdMale;
    RadioButton rdFemale;
    CheckBox ckTennis,ckFutbal,ckOthers;
    public void dialogNotify(String message){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(registerform.this);
        builder1.setMessage(message);
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
    public String handleListHobbies(List<String>hobbies){
        String resultHobbies="";
        int len = hobbies.size();

        if(len==0)
            return resultHobbies;

        for(int i=0;i<len-1;i++){
            resultHobbies= resultHobbies+ hobbies.get(i)+", ";
        }
        return resultHobbies + hobbies.get(len-1);
    }
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
        btnSignup = (Button) this.findViewById(R.id.btnSignup);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername.setText("");
                txtPassword.setText("");
                txtRetype.setText("");
                txtBirthdate.setText("");
                rdFemale.setChecked(false);
                rdMale.setChecked(false);
                ckTennis.setChecked(false);
                ckFutbal.setChecked(false);
                ckOthers.setChecked(false);

            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String retype = txtRetype.getText().toString();
                String birthdate= txtBirthdate.getText().toString();
                List<String > listHobbies = new ArrayList<>();
                if(ckTennis.isChecked()){
                    listHobbies.add("Tennis");
                }
                if(ckFutbal.isChecked()){
                    listHobbies.add("Futbal");
                }
                if(ckOthers.isChecked()){
                    listHobbies.add("Others");
                }
                String hobbies = handleListHobbies(listHobbies);
                if(!rdFemale.isChecked()&&!rdMale.isChecked()){
                    dialogNotify("Gender is not allowed to empty");
                    return ;
                }
                String gender = "Female";
                if(rdMale.isChecked()){
                    gender = "Male";
                }

                if(!password.equals(retype)){
                    dialogNotify("Password is not match");
                    return;
                }
                if(birthdate.isEmpty()){
                    dialogNotify("Birthdate is not allowed to empty");
                    return;
                }
                Intent intent = new Intent(getApplicationContext(),resultform.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("birthdate",birthdate);
                intent.putExtra("gender",gender);
                intent.putExtra("hobbies",hobbies);
                startActivity(intent);
                finish();
            }
        });

    }
}