package com.killerwilmer.androidweardemo;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends WearableActivity {

    TextView helloTextView;
    Button clickButton;

    public void click(View view) {
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = (TextView) findViewById(R.id.helloTextView);
        clickButton = (Button) findViewById(R.id.clickButton);

        helloTextView.setText("Hello Killer");

        // Enables Always-on
        setAmbientEnabled();
    }
}
