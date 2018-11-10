package com.example.android.tamilapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> relations = new ArrayList<>();

        relations.add(new Word("Father","அப்பா",R.drawable.father));
        relations.add(new Word("Mother","அம்மா",R.drawable.mother));
        relations.add(new Word("Brother","சகோதரன்",R.drawable.brother));
        relations.add(new Word("Sister","சகோதரி",R.drawable.sister));
        relations.add(new Word("Grand Father","தாத்தா",R.drawable.grand_father));
        relations.add(new Word("Grand Mother","பாட்டி",R.drawable.grand_mother));
        relations.add(new Word("Uncle","மாமா",R.drawable.uncle));
        relations.add(new Word("Aunty","அத்தை",R.drawable.aunty));
        relations.add(new Word("Son","மகன்",R.drawable.son));
        relations.add(new Word("Daughter","மகள்",R.drawable.daughter));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, relations, R.color.category_family);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
