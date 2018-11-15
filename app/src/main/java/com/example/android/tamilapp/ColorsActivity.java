package com.example.android.tamilapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an Arraylist of colors (Data)
        final ArrayList<Word> colors = new ArrayList<>();

        colors.add(new Word("Red","சிவப்பு",R.drawable.red_color, R.raw.tamil_red));
        colors.add(new Word("Green","பச்சை",R.drawable.green_color, R.raw.tamil_green));
        colors.add(new Word("Blue","நீலம்",R.drawable.blue_color, R.raw.tamil_blue));
        colors.add(new Word("Yellow","மஞ்சள்",R.drawable.yellow_color, R.raw.tamil_yellow));
        colors.add(new Word("White","வெள்ளை",R.drawable.white_color, R.raw.tamil_white));
        colors.add(new Word("Black","கருப்பு",R.drawable.black_color, R.raw.tamil_black));
        colors.add(new Word("Orange","ஆரஞ்சு(செம்மஞ்சள்)",R.drawable.orange_color, R.raw.tamil_orange));
        colors.add(new Word("Brown","பழுப்பு",R.drawable.brown_color, R.raw.tamil_brown));
        colors.add(new Word("Indigo","இண்டிகோ",R.drawable.indigo_color, R.raw.tamil_indigo));
        colors.add(new Word("Violet","ஊதா",R.drawable.violet_color, R.raw.tamil_violet));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, colors, R.color.category_colors);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(itemsAdapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = colors.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceID());

                // Start the audio file
                mediaPlayer.start();
            }
        });
     }
}
