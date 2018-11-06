package com.example.android.tamilapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an Arraylist of colors (Data)
        ArrayList<Word> colors = new ArrayList<>();

        colors.add(new Word("Red","சிவப்பு",R.drawable.red_color));
        colors.add(new Word("Green","பச்சை",R.drawable.green_color));
        colors.add(new Word("Blue","நீலம்",R.drawable.blue_color));
        colors.add(new Word("Yellow","மஞ்சள்",R.drawable.yellow_color));
        colors.add(new Word("White","வெள்ளை",R.drawable.white_color));
        colors.add(new Word("Black","கருப்பு",R.drawable.black_color));
        colors.add(new Word("Orange","ஆரஞ்சு(செம்மஞ்சள்)",R.drawable.orange_color));
        colors.add(new Word("Brown","பழுப்பு",R.drawable.brown_color));
        colors.add(new Word("Indigo","இண்டிகோ",R.drawable.indigo_color));
        colors.add(new Word("Violet","ஊதா",R.drawable.violet_color));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, colors);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

     }
}
