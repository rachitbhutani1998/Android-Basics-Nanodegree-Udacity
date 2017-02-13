package com.example.android.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.subway), R.drawable.subway));
        words.add(new Words(getString(R.string.mcdonalds), R.drawable.mcdonalds));
        words.add(new Words(getString(R.string.dominos), R.drawable.dominos));
        words.add(new Words(getString(R.string.bbq), R.drawable.bbqnation));
        words.add(new Words(getString(R.string.kfc), R.drawable.kfc));
        InputAdapter adapter = new InputAdapter(this, words, R.color.restaurants);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
