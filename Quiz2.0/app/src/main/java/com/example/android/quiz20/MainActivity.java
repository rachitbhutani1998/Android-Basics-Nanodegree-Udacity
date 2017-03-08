package com.example.android.quiz20;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {
    int score;
    CheckBox checkbox1;
    CheckBox checkbox2;
    CheckBox checkbox4;
    CheckBox checkbox3;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio5;
    EditText textField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1 = (CheckBox) findViewById(R.id.ans_check_1);
        checkbox2 = (CheckBox) findViewById(R.id.ans_check_2);
        checkbox3 = (CheckBox) findViewById(R.id.ans_check_3);
        checkbox4 = (CheckBox) findViewById(R.id.ans_check_4);
        radio1 = (RadioButton) findViewById(R.id.ans1);
        radio2 = (RadioButton) findViewById(R.id.ans2);
        radio5 = (RadioButton) findViewById(R.id.ans5);
        textField = (EditText) findViewById(R.id.answer_label);
    }


    public void submitQuiz(View view) {
        score = 0;
        String textAns = textField.getText().toString().trim();
        if (textAns.equalsIgnoreCase("tongue"))
            score += 1;
        if (checkbox1.isChecked() && checkbox2.isChecked() && !checkbox3.isChecked() && !checkbox4.isChecked())
            score += 1;
        if (radio1.isChecked())
            score += 1;
        if (radio2.isChecked())
            score += 1;
        if (radio5.isChecked())
            score += 1;
        if (score == 5)
        {
            Snackbar snackbar = Snackbar
                    .make(view, "You scored 5 out of 5!", Snackbar.LENGTH_LONG);
            snackbar.show();
            snackbar.setAction("Share", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent=new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT,"I scored full marks in the Quiz App made by Rachit.");
                    Intent chooser=new Intent(Intent.createChooser(shareIntent,"Share Via"));
                    startActivity(chooser);

                }
            });
        }
        else
        {
            Snackbar snackbar = Snackbar
                    .make(view, "You have scored " + score + " points.", Snackbar.LENGTH_LONG);
            snackbar.show();
            snackbar.setAction("Share", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent=new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT,"I scored "+score+" marks in the Quiz App made by Rachit.");
                    Intent chooser=new Intent(Intent.createChooser(shareIntent,"Share Via"));
                    startActivity(chooser);
                }
            });
        }

    }
}
