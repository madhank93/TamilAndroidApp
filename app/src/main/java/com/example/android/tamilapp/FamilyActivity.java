package com.example.android.tamilapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

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

        final ArrayList<Word> relations = new ArrayList<>();

        relations.add(new Word("Father","அப்பா",R.drawable.father, R.raw.tamil_appa));
        relations.add(new Word("Mother","அம்மா",R.drawable.mother, R.raw.tamil_amma));
        relations.add(new Word("Brother","சகோதரன்",R.drawable.brother, R.raw.tamil_bro));
        relations.add(new Word("Sister","சகோதரி",R.drawable.sister, R.raw.tamil_sis));
        relations.add(new Word("Grand Father","தாத்தா",R.drawable.grand_father, R.raw.tamil_grand_dad));
        relations.add(new Word("Grand Mother","பாட்டி",R.drawable.grand_mother, R.raw.tamil_grand_mom));
        relations.add(new Word("Uncle","மாமா",R.drawable.uncle, R.raw.tamil_uncle));
        relations.add(new Word("Aunty","அத்தை",R.drawable.aunty, R.raw.tamil_aunty));
        relations.add(new Word("Son","மகன்",R.drawable.son, R.raw.tamil_son));
        relations.add(new Word("Daughter","மகள்",R.drawable.daughter, R.raw.tamil_daughter));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, relations, R.color.category_family);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                Word word = relations.get(position);

                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceID()  );
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
