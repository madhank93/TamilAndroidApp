package com.example.android.tamilapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create an Arraylist of words (Data)
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("One","ஒன்று",R.drawable.one));
        words.add(new Word("Two","இரண்டு",R.drawable.two));
        words.add(new Word("Three","மூன்று",R.drawable.three));
        words.add(new Word("Four","நான்கு",R.drawable.four));
        words.add(new Word("Five","ஐந்து",R.drawable.five));
        words.add(new Word("Six","ஆறு",R.drawable.six));
        words.add(new Word("Seven","ஏழு",R.drawable.seven));
        words.add(new Word("Eight","எட்டு",R.drawable.eight));
        words.add(new Word("Nine","ஒன்பது",R.drawable.nine));
        words.add(new Word("Ten","பத்து",R.drawable.ten));
        words.add(new Word("Eleven","பதினொன்று",R.drawable.eleven));
        words.add(new Word("Twelve","பன்னிரண்டு",R.drawable.twelve));
        words.add(new Word("Thirteen","பதின்மூன்று",R.drawable.thirteen));
        words.add(new Word("Fourteen","பதினான்கு",R.drawable.fourteen));
        words.add(new Word("Fifteen","பதினைந்து",R.drawable.fifteen));
        words.add(new Word("Sixteen","பதினாறு",R.drawable.sixteen));
        words.add(new Word("Seventeen","பதினேழு",R.drawable.seventeen));
        words.add(new Word("Eighteen","பதினெட்டு",R.drawable.eighteen));
        words.add(new Word("Nineteen","பத்தொன்பது",R.drawable.nineteen));
        words.add(new Word("Twenty","இருபது",R.drawable.twenty));
        words.add(new Word("Twenty one","இருபத்து ஒன்று",R.drawable.twenty_one));
        words.add(new Word("Twenty two","இருபத்து இரண்டு",R.drawable.twenty_two));
        words.add(new Word("Twenty three","இருபத்து மூன்று",R.drawable.twenty_three));
        words.add(new Word("Twenty four","இருபத்து நான்கு",R.drawable.twenty_four));
        words.add(new Word("Twenty five","இருபத்து ஐந்து",R.drawable.twenty_five));
        words.add(new Word("Thirty","முப்பது",R.drawable.thirty));
        words.add(new Word("Forty","நாற்பது",R.drawable.forty));
        words.add(new Word("Fifty","ஐம்பது",R.drawable.fifty));
        words.add(new Word("Sixty","அறுபது",R.drawable.sixty));
        words.add(new Word("Seventy","எழுபது",R.drawable.seventy));
        words.add(new Word("Eighty","எண்பது",R.drawable.eighty));
        words.add(new Word("Ninety","தொண்ணூறு",R.drawable.ninety));
        words.add(new Word("One Hundred","நூறு",R.drawable.hundred));
        words.add(new Word("Two Hundred","இருநூறு",R.drawable.two_hundred));
        words.add(new Word("Three Hundred","முன்னூறு",R.drawable.three_hundred));
        words.add(new Word("One thousand","ஆயிரம்",R.drawable.thousand));
        words.add(new Word("Two thousand","இரண்டு ஆயிரம்",R.drawable.two_thousand));
        words.add(new Word("Hundred thousand","ஒரு இலட்சம்",R.drawable.hundred_thousand));
        words.add(new Word("One million","பத்து இலட்சம்",R.drawable.million));
        words.add(new Word("Ten million","ஒரு கோடி",R.drawable.ten_million));

        // Create an instance for Custom Array Adapter(In this case WordAdapter)
        // (ArrayAdapter - adapter converts an ArrayList of objects into View items loaded into the ListView container)
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);

        // Connect the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
