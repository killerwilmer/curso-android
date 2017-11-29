package com.killerwilmer.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase database = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            database.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

//            database.execSQL("INSERT INTO users (name, age) VALUES('Wilmer', 31)");
//
//            database.execSQL("INSERT INTO users (name, age) VALUES('Leo', 30)");

            Cursor c = database.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            if (c!= null && c.moveToFirst()) {
                do {
                    Log.i("name", c.getString(nameIndex));
                    Log.i("age", Integer.toString(c.getInt(ageIndex)));
                } while (c.moveToNext());
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
