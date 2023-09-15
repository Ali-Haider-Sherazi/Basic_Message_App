package com.example.adouble;

import android.util.Log;

public class MsgInfo {
    int s_id;
    int r_id;
    String s_name;
    String r_name;
    String s_msg;

    public MsgInfo(int send, int rece, String sender, String rec,String msg)
    {
        s_id = send;
        r_id = rece;
        s_name = sender;
        r_name = rec;
        this.s_msg=msg;
    }
}
