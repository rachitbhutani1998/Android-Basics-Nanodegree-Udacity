package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class touristSpots extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.lake)));
        words.add(new Words(getString(R.string.rock)));
        words.add(new Words(getString(R.string.elante)));
        words.add(new Words(getString(R.string.zoo)));
        words.add(new Words(getString(R.string.rose)));
        InputAdapter adapter = new InputAdapter(this, words, R.color.tourists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
