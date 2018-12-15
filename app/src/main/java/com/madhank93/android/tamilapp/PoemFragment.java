package com.madhank93.android.tamilapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class PoemFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<Word> poem = new ArrayList<>();

        poem.add(new Word("Have desire to do good deeds","அறம் செய விரும்பு",R.drawable.ah));
        poem.add(new Word("Anger should be reduced/controlled","ஆறுவது சினம்",R.drawable.aaah));
        poem.add(new Word("Help to your best possible extent","இயல்வது கரவேல்",R.drawable.ee));
        poem.add(new Word("Don’t stop doing charity","ஈவது விலக்கேல்",R.drawable.eeee));
        poem.add(new Word("Do not boast about your possession","உடையது விளம்பேல்",R.drawable.oo));
        poem.add(new Word("Do not give up hope/self-confidence","ஊக்கமது கைவிடேல்",R.drawable.how));
        poem.add(new Word("Do not underestimate the power of learning","எண் எழுத்து இகழேல்",R.drawable.ae));
        poem.add(new Word("To accept alms is a shameful act","ஏற்பது இகழ்ச்சி",R.drawable.aeae));
        poem.add(new Word("Before eating, share food with those who need","ஐயமிட்டு உண்",R.drawable.ai));
        poem.add(new Word("Act with high moral standards","ஒப்புர வொழுகு",R.drawable.oh));
        poem.add(new Word("Never stop learning","ஓதுவது ஒழியேல்",R.drawable.ohoh));
        poem.add(new Word("Never envy/talk bad about others","ஒளவியம் பேசேல்",R.drawable.awh));
        poem.add(new Word("Do not be stingy in selling food grains","அஃகஞ் சுருக்கேல்",R.drawable.akku));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), poem, R.color.category_poem);

        // Connect the adapter to a ListView
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return  rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
