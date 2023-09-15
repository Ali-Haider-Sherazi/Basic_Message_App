package com.example.adouble;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Display extends  AppCompatActivity {
    public int val;
    public static String name;
    public static int id;
    public static String selectedFromList;
    LoginPage log= new LoginPage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        ArrayList<Word> msg = new ArrayList<Word>();

        Activity2 ac = new Activity2();

        for(int i = 0; i< log.LogInfo.size(); i++)
        {
            if(log.LogInfo.get(i).s_name!=log.getS_name())
            {
                msg.add(new Word("......"+log.LogInfo.get(i).id, "Send Message"+i, log.LogInfo.get(i).s_name, R.drawable.family_father, log.LogInfo.get(i).id));
            }
        }
        msg.add(new Word("Fine","MoM, How Are You?","MoM",R.drawable.family_mother,log.LogInfo.get(0).id));
        /*
        if(log.getId()==1) {
            if(ac.msgSystem.size()==0)
            msg.add(new Word("......", "Type SomeThing Here", "DAD", R.drawable.family_father));
            else //for last msg
            msg.add(new Word("......", "Type SomeThing Here", "DAD", R.drawable.family_father));
            name="Dady";
            id=2;

        }
        else {
            if(ac.msgSystem.size()==0)
                msg.add(new Word("......", "Type SomeThing Here", "Son", R.drawable.family_son));
            else
                msg.add(new Word("......", "Type SomeThing Here", "Son", R.drawable.family_son));
            name="Son";
            id=1;
        }
        msg.add(new Word("Fine","MoM, How Are You?","MoM",R.drawable.family_mother));
Incorrect which to be corrected
        for(int i=0;i<=log.LogInfo.size();i++)
        {
            msg.add(new Word("......", "Type SomeThing Here", log.LogInfo.get(i).s_name, R.drawable.family_father));
        }
*/

        WordAdapter itemsAdapter = new WordAdapter(this,msg,R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i<=listView.getHeight())
                {
                    id=0;
                    setData( msg.get(i).Name);
                    openDadContact();
                }
            }
        });

    }
    public void openDadContact()
    {
        Intent i= new Intent(this,Activity2.class);
        startActivity(i);
    }
    public void setData(String s) {
        /*Name of reciver*/
        selectedFromList = s;
        for (int i = 0; i < log.LogInfo.size(); i++) {
            if (log.LogInfo.get(i).s_name == selectedFromList) {
                setId(log.LogInfo.get(i).id);
            }
        }
    }

    public void setId(int ids)
    {
        id=ids;
    }
    public String getVal()
    {
        return selectedFromList;
    }

    public int getId() {
        return id;
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(this, LoginPage.class));
    }
}

 /*
        Activity2 obj = new Activity2();
        list.add("AliShah");
        list=obj.getArrayList();
            Log.d("tag","Hello my answer "+list.size());
            LinearLayout rootView = (LinearLayout) findViewById(R.id.list);
            TextView wordView = new TextView(this);
            wordView.setText(list.get(0));
            rootView.addView(wordView);
            TextView v = findViewById(R.id.d);
*/
