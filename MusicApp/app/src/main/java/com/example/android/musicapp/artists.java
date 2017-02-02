package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class artists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
    }
    public void home(View view){
        Intent homeIntent = new Intent(this,MainActivity.class);
        startActivity(homeIntent);
    }
    public void playlistCategory(View view){
        Intent playlistIntent = new Intent(this,playlists.class);
        startActivity(playlistIntent);
    }
    public void nowPlayingCategory(View view){
        Intent nowPlayingIntent = new Intent(this,nowplaying.class);
        startActivity(nowPlayingIntent);
    }
    public void albumsCategory(View view){
        Intent albumsIntent = new Intent(this,albums.class);
        startActivity(albumsIntent);
    }
    public void tracksCategory(View view){
        Intent tracksIntent = new Intent(this,tracks.class);
        startActivity(tracksIntent);
    }
}
