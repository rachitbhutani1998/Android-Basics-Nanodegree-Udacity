package com.example.android.habittracker.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Rachit on 12/10/2016.
 */
public class HabitContract {
    public static final String CONTENT_AUTHORITY=
            "com.example.android.habbittracker";

    public static final Uri BASE_CONTENT =
            Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_HABIT = "habit";

    public static final class HabitEntry implements BaseColumns {

        public static final Uri CONTENT_URI=
                BASE_CONTENT.buildUpon().appendPath(PATH_HABIT).build();

        public static final String TABLE_NAME="habits";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME="habit";
        public static final String COLUMN_EFFICIENCY = "Efficiency";

    }
}
