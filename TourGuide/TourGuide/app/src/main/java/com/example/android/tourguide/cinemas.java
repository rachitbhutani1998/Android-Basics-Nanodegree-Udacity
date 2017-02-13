package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class cinemas extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.elante), R.drawable.elante));
        words.add(new Words(getString(R.string.cinepolis), R.drawable.cinepolis));
        words.add(new Words(getString(R.string.piccadily), R.drawable.piccadily));
        words.add(new Words(getString(R.string.wave), R.drawable.wavecinema));
        InputAdapter adapter = new InputAdapter(this, words, R.color.cinemas);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
