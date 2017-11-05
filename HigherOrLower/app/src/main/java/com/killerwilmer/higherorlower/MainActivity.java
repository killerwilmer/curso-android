package com.killerwilmer.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;

    public void makeTest(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void guessClick(View view) {
        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);

        int guessInt = Integer.parseInt(guessEditText.getText().toString());

        if (guessInt > randomNumber) {
            makeTest("Lower!");
        } else if (guessInt < randomNumber) {
            makeTest("Higher!");
        } else {
            makeTest("That's right! Try again!");

            Random rand = new Random();

            randomNumber = rand.nextInt(20) + 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();

        randomNumber = rand.nextInt(20) + 1;
    }
}
