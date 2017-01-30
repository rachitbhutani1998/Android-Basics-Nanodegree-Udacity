package com.example.android.quiz20;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz20.R;

import java.util.Objects;

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
            Toast.makeText(this, "Great.. You scored the maximum marks i.e. 5", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "You have scored " + score + " points.", Toast.LENGTH_SHORT).show();

    }
}
