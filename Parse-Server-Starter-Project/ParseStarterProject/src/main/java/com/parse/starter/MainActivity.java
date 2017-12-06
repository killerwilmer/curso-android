/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Save object
    /* ParseObject score = new ParseObject("Score");
    score.put("username", "wilmer");
    score.put("score", 86);
    score.saveInBackground(new SaveCallback() {
      @Override
      public void done(ParseException e) {
        if (e == null) {
          Log.i("SaveInBackground", "Successful");
        } else {
          Log.i("SaveInBackground", "Failed. Error: " + e.toString());
        }
      }
    }); */


    // Update value
    /* ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.getInBackground("WPg92Btpxw", new GetCallback<ParseObject>() {
      @Override
      public void done(ParseObject object, ParseException e) {
        if (e == null && object != null) {

          object.put("score", 200); // Update value
          object.saveInBackground();

          Log.i("ObjectValue", object.getString("username"));
          Log.i("ObjectValue", Integer.toString(object.getInt("score")));
        }
      }
    }); */


    // Query find
    /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.whereEqualTo("username", "killer");
    query.setLimit(1);

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if ( e == null) {
          Log.i("findInBackground", "Retrive " + objects.size() + " objects");

          if (objects.size() > 0) {
            for (ParseObject object : objects) {
              Log.i("findInBackground", Integer.toString(object.getInt("score")));
            }
          }
        }
      }
    });*/


    // Update objects from find
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

    query.whereGreaterThan("score", 200);

    query.findInBackground(new FindCallback<ParseObject>() {
      @Override
      public void done(List<ParseObject> objects, ParseException e) {
        if (e == null && objects != null) {
          for (ParseObject object : objects) {
            object.put("score", object.getInt("score") + 50);
            object.saveInBackground();
          }
        }
      }
    });

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}