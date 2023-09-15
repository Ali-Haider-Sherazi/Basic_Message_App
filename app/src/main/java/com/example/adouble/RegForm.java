package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegForm extends AppCompatActivity {

    Button button;
    EditText name,pass,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);

        button = findViewById(R.id.Registered);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataEntered();
            }
        });
    }
    public void DataEntered()
    {
        name= findViewById(R.id.regName);
        pass= findViewById(R.id.pass);
        mail= findViewById(R.id.mail);
        LoginPage lg = new LoginPage();
        Id info = new Id(lg.userId,name.getText().toString(),mail.getText().toString(),pass.getText().toString());
        lg.LogInfo.add(info);
        lg.userId++;
        openNew();
    }

    public void openNew() {
        startActivity(new Intent(this,LoginPage.class));
    }
}