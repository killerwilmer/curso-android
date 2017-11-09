package com.killerwilmer.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisecondsUntilDone) {
                // CountDown is counting down (every second)
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone / 1000));
            }

            @Override
            public void onFinish() {
                // Counter is finished (after 10 second)
                Log.i("Done!", "Countdown Timer Finished");
            }
        }.start();



        // For Handler and Runnable

//        final Handler handler = new Handler();
//
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//
//                // Insert code to be run every second
//
//                Log.i("Runnable has run!", "a second most  have passed");
//
//                handler.postDelayed(this, 1000);
//            }
//        };
//
//        handler.post(run);
    }
}
