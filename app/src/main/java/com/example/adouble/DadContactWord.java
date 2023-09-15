package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DadContactWord extends AppCompatActivity {
    String Name;
    String Number;
    String Text1;
    String Text2;
    private int mImgResourceId=No_Img;
    public final static int No_Img=-1;
    public DadContactWord(String name , String number,String text1,String text2)
    {
        Name = name;
        Number = number;
        Text1 =text1;
        Text2 =text2;
    }
    public DadContactWord(String name , String number,String text1,String text2,int ImgResourceId)
    {
        Name = name;
        Number = number;
        Text1 =text1;
        Text2 =text2;
        mImgResourceId = ImgResourceId;
    }
    public String Name()
    {
        return Name;
    }

    public String Number()
    {
        return Number;
    }

    public String Text1()
    {
        return Text1;
    }

    public String Text2()
    {
        return Text2;
    }

    public int mImgResourceId()
    {
        return mImgResourceId;
    }

    public boolean hasImg()
    {
        return mImgResourceId != No_Img;
    }

}