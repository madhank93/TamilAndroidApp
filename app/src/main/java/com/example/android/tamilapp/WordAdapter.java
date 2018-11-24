package com.example.android.tamilapp;

import android.app.Activity;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int mColorResourceId ) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        this.mColorResourceId = mColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID tamil_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.tamil_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getTamilTranslation());

        // Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        // Get the version number from the current currentWord object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageIcon = listItemView.findViewById(R.id.list_item_icon);

        // From the currentWord object check if it has image.
        // If it has image; set the image to iconView.
        // Else hide the image view
        if (currentWord.hasImage()) {
            imageIcon.setImageResource(currentWord.getImageResourceId());
        }
        else {
            imageIcon.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
