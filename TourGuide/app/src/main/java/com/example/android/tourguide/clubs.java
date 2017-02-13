package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class clubs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.haze), R.drawable.haze));
        words.add(new Words(getString(R.string.paara), R.drawable.paara));
        words.add(new Words(getString(R.string.score), R.drawable.score));
        words.add(new Words(getString(R.string.hangout), R.drawable.hangout));
        InputAdapter adapter = new InputAdapter(this, words, R.color.clubs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
