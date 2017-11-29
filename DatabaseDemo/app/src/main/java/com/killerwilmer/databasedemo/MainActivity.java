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

            database.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INTEGER(3), id INTEGER PRIMARY KEY)");

            database.execSQL("INSERT INTO users (name, age) VALUES('Wilmer', 31)");

            database.execSQL("INSERT INTO users (name, age) VALUES('Leo', 30)");

            //Cursor c = database.rawQuery("SELECT * FROM users", null);
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE age <= 30", null);
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE age <= 30 AND name == 'Leo'", null);
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE name LIKE 'W%'", null);
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE name LIKE '%e%'", null);
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE name LIKE '%e%' LIMIT 1", null);

            //database.execSQL("DELETE FROM users WHERE name IN (SELECT name FROM users WHERE name = 'Leo' LIMIT 1)");
            //database.execSQL("DELETE FROM users WHERE id = 1");

            //database.execSQL("UPDATE users SET age = 32 WHERE name = 'Wilmer'");

            Cursor c = database.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            if (c!= null && c.moveToFirst()) {
                do {
                    Log.i("name", c.getString(nameIndex));
                    Log.i("age", Integer.toString(c.getInt(ageIndex)));
                    Log.i("id", Integer.toString(c.getInt(idIndex)));
                } while (c.moveToNext());
            }

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
