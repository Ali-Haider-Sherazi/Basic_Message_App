//package com.example.adouble;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class ContactWordAdapter extends ArrayAdapter<DadContactWord> {
//
//    private int ColorID;
//    public ContactWordAdapter(Activity context, ArrayList<DadContactWord> words, int colors) {
//        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
//        // the second argument is used when the ArrayAdapter is populating a single TextView.
//        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
//        // going to use this second argument, so it can be any value. Here, we used 0.
//        super(context, 0, words);
//        ColorID=colors;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Check if the existing view is being reused, otherwise inflate the view
//        View listItemView = convertView;
//        if(listItemView == null) {
//            listItemView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.list_item2, parent, false);
//        }
//
//
//        // Get the {@link AndroidFlavor} object located at this position in the list
//        DadContactWord currentWord = getItem(position);
//
//        // Find the TextView in the list_item.xml layout with the ID version_name
//        TextView miworkText = (TextView) listItemView.findViewById(R.id.Name);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        miworkText.setText(currentWord.Name());
//        //For The Name of Reciver
//        TextView NameText = (TextView) listItemView.findViewById(R.id.Number);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        NameText.setText(currentWord.Number());
//
//        // Find the ImageView in the list_item.xml layout with the ID image
//
//        ImageView imageView = listItemView.findViewById(R.id.image);
//        if(currentWord.hasImg())
//        {
//            // set this text on the number ImageView
//            imageView.setImageResource(currentWord.mImgResourceId());
//            imageView.setVisibility(View.VISIBLE);
//        }
//        else
//            imageView.setVisibility(View.GONE);
//        return listItemView;
//
//    }
//
//
//
//}
