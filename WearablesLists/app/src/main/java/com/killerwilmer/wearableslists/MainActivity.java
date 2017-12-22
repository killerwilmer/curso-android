package com.killerwilmer.wearableslists;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wearable.activity.WearableActivity;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends WearableActivity implements ExampleAdapter.ItemSelectedListener {

    private ArrayList<ExampleItemModel> exampleItemModels;
    WearableRecyclerView wearableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wearableRecyclerView = (WearableRecyclerView) findViewById(R.id.recycler_launcher_view);
        wearableRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        wearableRecyclerView.setLayoutManager(llm);


        exampleItemModels = new ArrayList<>();
        exampleItemModels.add(new ExampleItemModel("One",
                R.drawable.close_button));
        exampleItemModels.add(new ExampleItemModel("Two",
                R.drawable.close_button));
        exampleItemModels.add(new ExampleItemModel("Three",
                R.drawable.close_button));


        ExampleAdapter exampleAdapter = new ExampleAdapter(MainActivity.this, exampleItemModels);
        wearableRecyclerView.setAdapter(exampleAdapter);

        exampleAdapter.setListener(this);


        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    public void onItemSelected(int position) {
        Toast.makeText(this, "Position " + position, Toast.LENGTH_SHORT).show();
    }
}
