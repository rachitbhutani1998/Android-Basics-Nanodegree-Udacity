package com.example.android.football;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int goalA=0,foulA=0,goalB=0,foulB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goalPlusOneA(View view){
        goalA=goalA+1;
        goalsForTeamA(goalA);
    }
    public void foulPlusOneA(View view){
        foulA=foulA+1;
        foulsForTeamA("Fouls: " + foulA);
    }
    public void goalPlusOneB(View view){
        goalB=goalB+1;
        goalsForTeamB(goalB);
    }
    public void foulPlusOneB(View view){
        foulB=foulB+1;
        foulsForTeamB("Fouls: " + foulB);
    }
    public void reset(View view) {
        goalA = 0;
        goalB = 0;
        foulB = 0;
        foulA = 0;
        foulsForTeamB("Fouls: " + foulB);
        foulsForTeamA("Fouls: " + foulA);
        goalsForTeamB(goalB);
        goalsForTeamA(goalA);
    }
    public void goalsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_goals);
        scoreView.setText(String.valueOf(score));
    }
    public void foulsForTeamA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void goalsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_goals);
        scoreView.setText(String.valueOf(score));
    }
    public void foulsForTeamB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }
}

