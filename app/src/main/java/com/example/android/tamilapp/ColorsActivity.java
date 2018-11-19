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
    MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

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

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = colors.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceID());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
     }

     @Override
     protected void onStop(){
        super.onStop();
         // When the activity is stopped, release the media player resources because we won't
         // be playing any more sounds.
        releaseMediaPlayer();
     }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();
            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
