package com.example.adouble;

import android.util.Log;

public class Id {
    int id;
    String s_name;
    String mail;
    String password;

    public Id(int a, String name,String e, String pass)
    {
        id = a;
        s_name = name;
        this.mail= e;
        this.password= pass;
    }
}
