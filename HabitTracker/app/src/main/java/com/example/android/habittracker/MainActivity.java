package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitHelper;

public class MainActivity extends AppCompatActivity{



    SQLiteDatabase db;
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayDatabaseInfo();
        Button addRow = (Button) findViewById(R.id.add_button);
        addRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertHabit();
                TextView text = (TextView) findViewById(R.id.text_view);
                text.setText("");
                displayDatabaseInfo();
            }
        });
    }
    HabitHelper mHelper = new HabitHelper(this);

    private void displayDatabaseInfo() {

        db = mHelper.getReadableDatabase();


        Cursor cursor=readMethod();
        TextView displayView = (TextView) findViewById(R.id.text_view);
        try {
            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int habitColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int efficiencyColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_EFFICIENCY);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentHabit = cursor.getString(habitColumnIndex);
                int efficiency = cursor.getInt(efficiencyColumnIndex);
                displayView.append(("\n" + currentID + "    " +
                        currentHabit + "    " +
                        efficiency));
            }
        } finally {
            cursor.close();
        }
    }
    public Cursor readMethod() {
        String[] projection = {
                HabitEntry._ID,HabitEntry.COLUMN_HABIT_NAME,HabitEntry.COLUMN_EFFICIENCY
        };
        db = mHelper.getReadableDatabase();
        Cursor cursor =
                db.query(HabitEntry.TABLE_NAME,
                        projection,
                        null,
                        null,
                        null,
                        null,
                        null);
        return cursor;
    }
    public void insertHabit() {
        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitEntry.COLUMN_EFFICIENCY, "Efficiency");
        habitValues.put(HabitEntry.COLUMN_HABIT_NAME, "habit");
        db.insert(HabitEntry.TABLE_NAME,HabitEntry.COLUMN_HABIT_NAME, habitValues);
    }
}
