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
import android.util.Log;

import com.parse.ParseAnalytics;
import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    // Log Out
    ParseUser.logOut();

    // Ask for user logged
    if (ParseUser.getCurrentUser() != null) {
      Log.i("currentUser", "User: " + ParseUser.getCurrentUser().getUsername());
    } else {
      Log.i("currentUser", "User not logged in");
    }

    // Login User
    /*ParseUser.logInInBackground("killerwilmer", "abcdef", new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if (user != null) {
          Log.i("Login", "Successful");
        } else {
          Log.i("Login", "Failed " + e.toString());
        }
      }
    });*/

    // For create a User
    /* ParseUser parseUser = new ParseUser();

    parseUser.setUsername("killerwilmer");
    parseUser.setPassword("mypass");

    parseUser.signUpInBackground(new SignUpCallback() {
      @Override
      public void done(ParseException e) {
        if (e != null) {
          Log.i("Sign Up", "Successful");
        } else {
          Log.i("Sign Up", "Failed");
        }
      }
    });*/

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}