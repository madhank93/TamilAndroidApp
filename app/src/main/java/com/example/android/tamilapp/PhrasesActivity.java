package com.example.android.tamilapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrases = new ArrayList<>();

        phrases.add(new Word("Have desire to do good deeds","அறம் செய விரும்பு",R.drawable.ah));
        phrases.add(new Word("Anger should be reduced/controlled","ஆறுவது சினம்",R.drawable.aaah));
        phrases.add(new Word("Help to your best possible extent","இயல்வது கரவேல்",R.drawable.ee));
        phrases.add(new Word("Don’t stop doing charity","ஈவது விலக்கேல்",R.drawable.eeee));
        phrases.add(new Word("Do not boast about your possession","உடையது விளம்பேல்",R.drawable.oo));
        phrases.add(new Word("Do not give up hope/self-confidence","ஊக்கமது கைவிடேல்",R.drawable.how));
        phrases.add(new Word("Do not underestimate the power of learning","எண் எழுத்து இகழேல்",R.drawable.ae));
        phrases.add(new Word("To accept alms is a shameful act","ஏற்பது இகழ்ச்சி",R.drawable.aeae));
        phrases.add(new Word("Before eating, share food with those who need","ஐயமிட்டு உண்",R.drawable.ai));
        phrases.add(new Word("Act with high moral standards","ஒப்புர வொழுகு",R.drawable.oh));
        phrases.add(new Word("Never stop learning","ஓதுவது ஒழியேல்",R.drawable.ohoh));
        phrases.add(new Word("Never envy/talk bad about others","ஒளவியம் பேசேல்",R.drawable.awh));
        phrases.add(new Word("Do not be stingy in selling food grains","அஃகஞ் சுருக்கேல்",R.drawable.akku));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, phrases);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
