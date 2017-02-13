package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class hotels extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.jw)));
        words.add(new Words(getString(R.string.taj)));
        words.add(new Words(getString(R.string.shivalik)));
        words.add(new Words(getString(R.string.lemon)));
        words.add(new Words(getString(R.string.lalit)));
        InputAdapter adapter = new InputAdapter(this, words, R.color.hotels);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
