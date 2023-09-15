package com.example.adouble;

public class Word {
    String SentMsg;
    String RecMsg;
    String Name;
    static int id;
    private int mImgResourceId=No_Img;
    public final static int No_Img=-1;
    public Word(String Recieve , String Sent,String R_Name,int ids)
    {
        SentMsg = Sent;
        RecMsg = Recieve;
        Name =R_Name;
        id=ids;
    }
    public Word(String Recieve , String Sent,String R_Name ,int ImgResourceId,int ids)
    {
        id=ids;
        SentMsg = Sent;
        RecMsg = Recieve;
        Name =R_Name;
        mImgResourceId = ImgResourceId;
    }
    public String Send1()
    {
        return SentMsg;
    }

    public String Rec1()
    {
        return RecMsg;
    }

    public String Name1()
    {
        return Name;
    }

    public static int getId() {
        return id;
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

