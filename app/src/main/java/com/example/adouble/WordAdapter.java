package com.example.adouble;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int ColorID;
    public WordAdapter(Activity context, ArrayList<Word> words,int colors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        ColorID=colors;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miworkText = (TextView) listItemView.findViewById(R.id.Sending);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miworkText.setText(currentWord.Send1());
        //For The Name of Reciver
        TextView NameText = (TextView) listItemView.findViewById(R.id.Name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        NameText.setText(currentWord.Name1());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.Receiving);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.Rec1());
        // Find the ImageView in the list_item.xml layout with the ID image


        ImageView imageView = listItemView.findViewById(R.id.image);
        if(currentWord.hasImg())
        {
            // set this text on the number ImageView
            imageView.setImageResource(currentWord.mImgResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else
            imageView.setVisibility(View.GONE);
        return listItemView;

    }



}
