package com.killerwilmer.retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.killerwilmer.retrofit2.com.killerwilmer.retrofit2.controller.Controller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controller controller = new Controller();
        controller.start();
    }
}
