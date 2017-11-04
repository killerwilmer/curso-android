package com.killerwilmer.demoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFuntion(View view) {

        EditText myTextField = (EditText) findViewById(R.id.myTextField);

        Log.i("Info", myTextField.getText().toString());

        Toast.makeText(this, myTextField.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void newCat(View view) {
        ImageView catImageView = (ImageView) findViewById(R.id.catImageView);
        catImageView.setImageResource(R.drawable.cat2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
