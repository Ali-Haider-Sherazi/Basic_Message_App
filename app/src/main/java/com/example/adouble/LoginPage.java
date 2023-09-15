package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class LoginPage extends AppCompatActivity {
    EditText name;
    EditText pass;
    public static int id;
    public static int userId=3;
    public static String s_name;
    public static LinkedList<Id> LogInfo = new LinkedList<Id>();
    public static int add=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Button button =findViewById(R.id.login);
        if(add==0)
        addition();
        button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Form();
            }
        });
    }
    public void Form() {
        name = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        for(int i=0;i<LogInfo.size();i++) {
            if (name.getText().toString().equals(LogInfo.get(i).mail)) {
                if (pass.getText().toString().equals(LogInfo.get(i).password)) {
                    SetInfo(LogInfo.get(i).id, LogInfo.get(i).s_name);
                    Toast.makeText(this, "Login Id is "+LogInfo.get(i).id, Toast.LENGTH_SHORT).show();
                    Intent n = new Intent(this, Display.class);
                    startActivity(n);
                } else {
                    Toast.makeText(this, "Login Failed, Invalid Password or Mail", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void addition()
    {
        Id idd = new Id(1,"Ali Haider","Ali@gmail.com","1234");
        Id idd1 = new Id(2,"Syed Sherazi","Syed@gmail.com","1234");
        LogInfo.add(idd);
        LogInfo.add(idd1);
        add++;
    }
    public void SetInfo(int id,String name)
    {
        this.id= id;
        this.s_name=name;
        Log.d("idea ==",s_name);
    }
    public int getId() {
        return id;
    }

    public String getS_name() {
        return s_name;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
    }
}




