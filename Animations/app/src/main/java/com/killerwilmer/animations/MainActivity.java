package com.killerwilmer.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);

        bartImageView.animate().translationYBy(1000f).setDuration(2000);
        //bartImageView.animate().alpha(0f).setDuration(2000);

        //ImageView homerImageView = (ImageView) findViewById(R.id.homerImageView);
        //homerImageView.animate().alpha(1f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
