package com.killerwilmer.splitscreendemo;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);

        // Multi window mode has changed
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (isInMultiWindowMode()) {
                // We're in multi window mode!

            }

            if (isInPictureInPictureMode()) {
                // We're in picture in picture mode!
            }
        } else {
            Toast.makeText(this, "Error android version > 24", Toast.LENGTH_SHORT).show();
        }
    }
}
