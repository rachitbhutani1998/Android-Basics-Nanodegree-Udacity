package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Rachit on 12/10/2016.
 */
public class HabitHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "habits.db";
    public static final int DATABASE_VERSION = 1;

    public HabitHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("+HabitEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                    + HabitEntry.COLUMN_EFFICIENCY + " INTEGER NOT NULL DEFAULT 0);";
    public static final String DELETE_TABLE =
            "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME + ";";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
