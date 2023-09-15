package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    int u=0;
    RelativeLayout layout;
    ImageView imageView;
    ArrayList<String> msg= new ArrayList<>();
    static LinkedList<MsgInfo> msgSystem = new LinkedList<MsgInfo>();
    View screen;
    EditText data;
    TextView names;
    static int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);
        n=0;
        previous();
        /*
        msg.add("Hello Brother How are u now?");
        msg.add("Fine What About you");
        msg.add("Hello Brother How are u now?2");
        msg.add("Fine What About you2");
        msg.add("Hello Brother How are u now?3");
        msg.add("Fine What About you3");
        msg.add("Hello Brother How are u now?4");
        msg.add("Fine What About you4");
        msg.add("Hello Brother How are u now?5");
        msg.add("Fine What About you5");
*/
        Display dis = new Display();
        names= findViewById(R.id.Names);
        names.setText(dis.getVal());
        imageView = findViewById(R.id.setImg);
        if(dis.id==1) {
            imageView.setImageResource(R.drawable.family_son);
        }
        else
        imageView.setImageResource(R.drawable.family_father);
        LoginPage idd = new LoginPage();
        layout = findViewById(R.id.list);
        imageView = findViewById(R.id.send);
        data = findViewById(R.id.Msg);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MsgInfo message = new MsgInfo(idd.getId(), dis.getId(), idd.getS_name(), dis.name, data.getText().toString());
                    msgSystem.add(message);
                    Log.e("Hello ","= "+msgSystem.get(0).s_msg);
                    open();
                }
            });




    }
    public void previous()
    {
        if(msgSystem.size()>0) {
            LoginPage ids = new LoginPage();
            Display dis= new Display();
            for (int i = 0; i < msgSystem.size(); i++) {
                    screen = getLayoutInflater().inflate(R.layout.message, null, false);
                    LinearLayout layout = findViewById(R.id.msg_layout);
                    TextView first = screen.findViewById(R.id.id1);
                    TextView second = screen.findViewById(R.id.id2);
                    layout.addView(screen);
                    if (msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).r_id == dis.getId()) {
                        if (i > 0) {
                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
                                    RelativeLayout.TRUE);
                            params.rightMargin = 80;
                            second.setLayoutParams(params);
                            second.setText(msgSystem.get(i).s_msg + " ✔");
                        } else
                            first.setText(msgSystem.get(i).s_msg + " ✔");
                    } else if (msgSystem.get(i).r_id==ids.getId() && msgSystem.get(i).s_id == dis.getId()) {
                        if (i > 0 && msgSystem.get(i - 1).s_id != ids.getId()) {/*for second person, second msg*/
                            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
                                    RelativeLayout.TRUE);
                            params.leftMargin = 80;
                            first.setLayoutParams(params);
                            second.setText(msgSystem.get(i).s_msg + " ✔");
                        } else
                            second.setText(msgSystem.get(i).s_msg + " ✔✔");
                    }
                    else
                    {
                        first.setVisibility(View.INVISIBLE);
                        second.setVisibility(View.INVISIBLE);
                    }
                    n++;
            }
        }
    }
    public void open() {

        LoginPage ids = new LoginPage();
        Display dis = new Display();
        for (int i = n; i < msgSystem.size(); i++) {
                screen = getLayoutInflater().inflate(R.layout.message, null, false);
                LinearLayout layout = findViewById(R.id.msg_layout);
                TextView first = screen.findViewById(R.id.id1);
                TextView second = screen.findViewById(R.id.id2);

                layout.addView(screen);
                if (msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).r_id == dis.getId()) {
                    if (i > 0) {/*For second msg from same person*/
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
                                RelativeLayout.TRUE);
                        params.rightMargin = 80;
                        second.setLayoutParams(params);
                        second.setText(msgSystem.get(i).s_msg + " ✔");
                        first.setVisibility(View.INVISIBLE);
                    }
                    else if (msgSystem.get(i).s_msg != null)/*Fisrt msg from same person*/
                    {  first.setText(msgSystem.get(i).s_msg + " ✔");
                        second.setVisibility(View.INVISIBLE);}
                }
                n++;
            Toast.makeText(this, "S_Id " + msgSystem.get(i).s_id + " R_Id " + dis.getId(), Toast.LENGTH_SHORT).show();

        /*for(int i=0;i<=msgSystem.size();i++) {
            if(msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).s_msg!=null)
                first.append(msgSystem.get(i).s_msg);
            else if( msgSystem.get(i).s_msg!=null)
                second.append(msgSystem.get(i).s_msg);
            Toast.makeText(this, "size is equal to " + msgSystem.size() + " value " + msgSystem.get(0).s_msg, Toast.LENGTH_SHORT).show();
        }*/
        }
    }


}





/*
LoginPage ids = new LoginPage();
        Display dis = new Display();
        for (int i = n; i < msgSystem.size(); i++) {
                screen = getLayoutInflater().inflate(R.layout.message, null, false);
                LinearLayout layout = findViewById(R.id.msg_layout);
                TextView first = screen.findViewById(R.id.id1);
                TextView second = screen.findViewById(R.id.id2);

                layout.addView(screen);
                if (msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).r_id == dis.getId()) {
                    if (i > 0 && msgSystem.get(i - 1).s_id == ids.getId()) {
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
                                RelativeLayout.TRUE);
                        params.rightMargin = 80;
                        second.setLayoutParams(params);
                        second.setText(msgSystem.get(i).s_msg + " ✔");
                    } else if (msgSystem.get(i).s_id == ids.getId() && msgSystem.get(i).s_msg != null)
                        first.setText(msgSystem.get(i).s_msg + " ✔");
                } else if (msgSystem.get(i).s_msg != null) {
                    if (i > 0 && msgSystem.get(i - 1).s_id != ids.getId()) {
                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
                                RelativeLayout.TRUE);
                        params.leftMargin = 80;
                        first.setLayoutParams(params);
                        second.setText(msgSystem.get(i).s_msg + " ✔");
                    } else
                        second.setText(msgSystem.get(i).s_msg + " ✔");
                }
                n++;
            Toast.makeText(this, "name " + dis.getVal() + " value " + msgSystem.get(0).s_msg, Toast.LENGTH_SHORT).show();

 */






/*package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    protected Button button;
    public String name1;
    public List<String> name= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        button= findViewById(R.id.addition);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.add("First one ");
                opened();
                Toast.makeText(view.getContext(),"Added on List "+name.get(0) + name.size(),Toast.LENGTH_SHORT).show();
                Log.d("tag","Hello my answer "+ name.size());
            }
        });

    }
    public void opened()
    {
        EditText text=findViewById(R.id.Name1);
        name1=text.getText().toString();

    }
    public List<String> getArrayList()
    {
        name.add(name1);
        name.add("oho ");
        return name;
    }
}*/


/*
"""""With number name pic + two dummy text views""""""""""

package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    public int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);
        Display d = new Display();
        a=d.geti();

/*

        ArrayList<DadContactWord> msg = new ArrayList<DadContactWord>();
        msg.add(new DadContactWord("Dad","+923350439948","Hii Dad!","Yes",R.drawable.family_father));
        msg.add(new DadContactWord("MoM","+923350439948","MoM, How are You?","Fine",R.drawable.family_mother));
        ContactWordAdapter itemsAdapter = new ContactWordAdapter(this,msg,R.color.category_family);
*/
/*
    DadContactWord currentWord = null;
// Get the {@link AndroidFlavor} object located at this position in the list
        if(a==0)
                {
                currentWord = new DadContactWord("Dad", "+923350439948", "Hii Dad!", "Yes Buddy?", R.drawable.family_father);
                Toast.makeText(this,"Value of a=  "+a,Toast.LENGTH_SHORT).show();
                }
                else if(a==1)
                {
                currentWord = new DadContactWord("MoM","+923350439948","MoM, How are You?","Fine",R.drawable.family_mother);
                Toast.makeText(this,"Value of a=  "+a,Toast.LENGTH_SHORT).show();
                }
                // Find the TextView in the list_item.xml layout with the ID version_name
                TextView miworkText = (TextView) findViewById(R.id.Name);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                miworkText.setText(currentWord.Name());
                //For The Name of Reciver
                TextView NameText = (TextView) findViewById(R.id.Number);
                // Get the version name from the current AndroidFlavor object and
                // set this text on the name TextView
                NameText.setText(currentWord.Number());

                // Find the TextView in the list_item.xml layout with the ID version_number
                TextView numberTextView = (TextView) findViewById(R.id.First);
                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                numberTextView.setText(currentWord.Text1());
                // Find the ImageView in the list_item.xml layout with the ID image

                // Find the TextView in the list_item.xml layout with the ID version_number
                TextView numberTextView2 = (TextView) findViewById(R.id.Second);
                // Get the version number from the current AndroidFlavor object and
                // set this text on the number TextView
                numberTextView2.setText(currentWord.Text2());
                // Find the ImageView in the list_item.xml layout with the ID image

                ImageView imageView = findViewById(R.id.image);
                if(currentWord.hasImg())
                {
                // set this text on the number ImageView
                imageView.setImageResource(currentWord.mImgResourceId());
                imageView.setVisibility(View.VISIBLE);
                }
                else
                imageView.setVisibility(View.GONE);


                }

                }

                */

/*
                "XML FILE list_item2"
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:padding="16dp"
    android:minHeight="@dimen/list_item_height"
    android:backgroundTint="@color/tan_background">
    <ImageView
        android:id="@+id/image"
        android:layout_width="@dimen/list_item_height"
        android:layout_height="@dimen/list_item_height"
        android:background="@color/category_numbers"/>
    <LinearLayout
        android:id="@+id/text_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView
            android:id="@+id/Name"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textAppearance="?android:textAppearanceMedium"
            android:textColor="@color/white"
            android:textStyle="bold"
            android:background="@color/category_numbers"/>

        <TextView
            android:id="@+id/Number"
            android:layout_width="match_parent"
            android:layout_height="58dp"
            android:textAppearance="?android:textAppearanceMedium"
            android:textColor="@color/white"
            android:background="@color/category_numbers"/>

    </LinearLayout>

    <EditText
        android:id="@+id/editTextTextPersonName"
        android:layout_width="455dp"
        android:layout_height="480dp"
        android:layout_weight="1"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name" />

</LinearLayout>
 */

/*  With ArrayList
package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    int u=0;
    RelativeLayout layout;
    ImageView imageView;
    ArrayList<String> msg= new ArrayList<>();
    LinkedList<MsgInfo> cars = new LinkedList<MsgInfo>();
    View screen;
    EditText data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);
/*
        msg.add("Hello Brother How are u now?");
        msg.add("Fine What About you");
        msg.add("Hello Brother How are u now?2");
        msg.add("Fine What About you2");
        msg.add("Hello Brother How are u now?3");
        msg.add("Fine What About you3");
        msg.add("Hello Brother How are u now?4");
        msg.add("Fine What About you4");
        msg.add("Hello Brother How are u now?5");
        msg.add("Fine What About you5");
*/
/*        layout = findViewById(R.id.list);
                imageView = findViewById(R.id.send);
                imageView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        data = findViewById(R.id.Msg);
        if(data.getTextSize()!=0)
        {
        msg.add(data.getText().toString());
        msg.add(data.getText().toString());
        open();
        }
        }
        });

*/


/*
Correct one with msg send + receive

package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    int u=0;
    RelativeLayout layout;
    ImageView imageView;
    ArrayList<String> msg= new ArrayList<>();
    static LinkedList<MsgInfo> msgSystem = new LinkedList<MsgInfo>();
    View screen;
    EditText data;
    TextView names;
    static int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);
        n=0;
        previous();
        /*
        msg.add("Hello Brother How are u now?");
        msg.add("Fine What About you");
        msg.add("Hello Brother How are u now?2");
        msg.add("Fine What About you2");
        msg.add("Hello Brother How are u now?3");
        msg.add("Fine What About you3");
        msg.add("Hello Brother How are u now?4");
        msg.add("Fine What About you4");
        msg.add("Hello Brother How are u now?5");
        msg.add("Fine What About you5");
*/
/*
    Display dis = new Display();
        names= findViewById(R.id.Name);
                names.setText(dis.name);
                imageView = findViewById(R.id.setImg);
                if(dis.id==1) {
                imageView.setImageResource(R.drawable.family_son);
                }
                else
                imageView.setImageResource(R.drawable.family_father);
                LoginPage idd = new LoginPage();
                layout = findViewById(R.id.list);
                imageView = findViewById(R.id.send);
                data = findViewById(R.id.Msg);
                imageView.setOnClickListener(new View.OnClickListener() {
*/
/*@Override
public void onClick(View view) {
        MsgInfo message = new MsgInfo(idd.getId(), dis.id, idd.getS_name(), dis.name, data.getText().toString());
        msgSystem.add(message);
        Log.e("Hello ","= "+msgSystem.get(0).s_msg);
        open();
        }
        });




        }
        public void previous()
        {
        if(msgSystem.size()>0)
        {
        LoginPage ids = new LoginPage();
        for(int i=0;i<msgSystem.size();i++) {
        screen = getLayoutInflater().inflate(R.layout.message, null, false);
        LinearLayout layout = findViewById(R.id.msg_layout);
        TextView first = screen.findViewById(R.id.id1);
        TextView second = screen.findViewById(R.id.id2);
        layout.addView(screen);
        if (msgSystem.get(i).s_id == ids.getId() && msgSystem.get(i).s_msg != null)
        first.setText(msgSystem.get(i).s_msg + i);
        else if (msgSystem.get(i).s_msg != null)
        second.setText(msgSystem.get(i).s_msg);
        n++;
        }
        }
        }
        public void open() {

        LoginPage ids = new LoginPage();
        for(int i=n;i<msgSystem.size();i++) {
        screen = getLayoutInflater().inflate(R.layout.message,null,false);
        LinearLayout layout = findViewById(R.id.msg_layout);
        TextView first = screen.findViewById(R.id.id1);
        TextView second = screen.findViewById(R.id.id2);
        layout.addView(screen);
        if(msgSystem.get(i).s_id==ids.getId())
        first.setText(msgSystem.get(i).s_msg+i);
        else if(msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).s_msg!=null)
        first.setText(msgSystem.get(i).s_msg+i);
        else if( msgSystem.get(i).s_msg!=null)
        second.setText(msgSystem.get(i).s_msg);

        n++;
        }
        Toast.makeText(this, "msg " + msgSystem.size() + " value " + msgSystem.get(0).s_msg, Toast.LENGTH_SHORT).show();

        /*for(int i=0;i<=msgSystem.size();i++) {
            if(msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).s_msg!=null)
                first.append(msgSystem.get(i).s_msg);
            else if( msgSystem.get(i).s_msg!=null)
                second.append(msgSystem.get(i).s_msg);
            Toast.makeText(this, "size is equal to " + msgSystem.size() + " value " + msgSystem.get(0).s_msg, Toast.LENGTH_SHORT).show();
        }*/
       /* }
        }


        <-Till here->
        */









/* Proper generic code with two textview now going to update it make one text view...
package com.example.adouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    int u=0;
    RelativeLayout layout;
    ImageView imageView;
    ArrayList<String> msg= new ArrayList<>();
    static LinkedList<MsgInfo> msgSystem = new LinkedList<MsgInfo>();
    View screen;
    EditText data;
    TextView names;
    static int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item2);
        n=0;
        previous();
        /*
        msg.add("Hello Brother How are u now?");
        msg.add("Fine What About you");
        msg.add("Hello Brother How are u now?2");
        msg.add("Fine What About you2");
        msg.add("Hello Brother How are u now?3");
        msg.add("Fine What About you3");
        msg.add("Hello Brother How are u now?4");
        msg.add("Fine What About you4");
        msg.add("Hello Brother How are u now?5");
        msg.add("Fine What About you5");
*/
/*
Display dis = new Display();
        names= findViewById(R.id.Names);
                names.setText(dis.getVal());
                imageView = findViewById(R.id.setImg);
                if(dis.id==1) {
                imageView.setImageResource(R.drawable.family_son);
                }
                else
                imageView.setImageResource(R.drawable.family_father);
                LoginPage idd = new LoginPage();
                layout = findViewById(R.id.list);
                imageView = findViewById(R.id.send);
                data = findViewById(R.id.Msg);
                imageView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        MsgInfo message = new MsgInfo(idd.getId(), dis.getId(), idd.getS_name(), dis.name, data.getText().toString());
        msgSystem.add(message);
        Log.e("Hello ","= "+msgSystem.get(0).s_msg);
        open();
        }
        });




        }
        public void previous()
        {
        if(msgSystem.size()>0) {
        LoginPage ids = new LoginPage();
        Display dis= new Display();
        for (int i = 0; i < msgSystem.size(); i++) {
        screen = getLayoutInflater().inflate(R.layout.message, null, false);
        LinearLayout layout = findViewById(R.id.msg_layout);
        TextView first = screen.findViewById(R.id.id1);
        TextView second = screen.findViewById(R.id.id2);
        layout.addView(screen);
        if (msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).r_id == dis.getId()) {
        if (i > 0) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
        RelativeLayout.TRUE);
        params.rightMargin = 80;
        second.setLayoutParams(params);
        second.setText(msgSystem.get(i).s_msg + " ✔");
        } else
        first.setText(msgSystem.get(i).s_msg + " ✔");
        } else if (msgSystem.get(i).r_id==ids.getId() && msgSystem.get(i).s_id == dis.getId()) {
        if (i > 0 && msgSystem.get(i - 1).s_id != ids.getId()) {*/
/*for second person, second msg*//*

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
        RelativeLayout.TRUE);
        params.leftMargin = 80;
        first.setLayoutParams(params);
        second.setText(msgSystem.get(i).s_msg + " ✔");
        } else
        second.setText(msgSystem.get(i).s_msg + " ✔✔");
        }
        else
        {
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        }
        n++;
        }
        }
        }
        public void open() {

        LoginPage ids = new LoginPage();
        Display dis = new Display();
        for (int i = n; i < msgSystem.size(); i++) {
        screen = getLayoutInflater().inflate(R.layout.message, null, false);
        LinearLayout layout = findViewById(R.id.msg_layout);
        TextView first = screen.findViewById(R.id.id1);
        TextView second = screen.findViewById(R.id.id2);

        layout.addView(screen);
        if (msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).r_id == dis.getId()) {
        if (i > 0) {*/
/*For second msg from same person*//*

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,
        RelativeLayout.TRUE);
        params.rightMargin = 80;
        second.setLayoutParams(params);
        second.setText(msgSystem.get(i).s_msg + " ✔");
        first.setVisibility(View.INVISIBLE);
        }
        else if (msgSystem.get(i).s_msg != null)*/
/*Fisrt msg from same person*//*

        {  first.setText(msgSystem.get(i).s_msg + " ✔");
        second.setVisibility(View.INVISIBLE);}
        }
        n++;
        Toast.makeText(this, "S_Id " + msgSystem.get(i).s_id + " R_Id " + dis.getId(), Toast.LENGTH_SHORT).show();

        */
/*for(int i=0;i<=msgSystem.size();i++) {
            if(msgSystem.get(i).s_id==ids.getId() && msgSystem.get(i).s_msg!=null)
                first.append(msgSystem.get(i).s_msg);
            else if( msgSystem.get(i).s_msg!=null)
                second.append(msgSystem.get(i).s_msg);
            Toast.makeText(this, "size is equal to " + msgSystem.size() + " value " + msgSystem.get(0).s_msg, Toast.LENGTH_SHORT).show();
        }*//*

        }
        }


        }
*/

