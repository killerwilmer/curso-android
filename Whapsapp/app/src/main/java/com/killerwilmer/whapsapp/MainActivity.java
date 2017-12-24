package com.killerwilmer.whapsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button signupLoginButton;
    TextView loginModeTextView;

    Boolean loginModeActive = false;

    public void redirectIfLoggedIn() {
        if (ParseUser.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
            startActivity(intent);
        }
    }

    public void loginMode(View view) {
        if (loginModeActive) {
            loginModeActive = false;
            signupLoginButton.setText("Sign Up");
            loginModeTextView.setText("Or, log in");

        } else {
            loginModeActive = true;
            signupLoginButton.setText("Log In");
            loginModeTextView.setText("Or, sign up");
        }
    }

    public void signupLogin(View view) {

        if (loginModeActive) {

            ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null) {
                        Log.i("Info", "user logged in");

                        redirectIfLoggedIn();
                    } else {
                        Toast.makeText(MainActivity.this, "Error " + e.getMessage().substring(e.getMessage().indexOf(" ")), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            ParseUser user = new ParseUser();

            user.setUsername(usernameEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.i("Info", "User signed up");
                        redirectIfLoggedIn();
                    } else {
                        Toast.makeText(MainActivity.this, "Error " + e.getMessage().substring(e.getMessage().indexOf(" ")), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        signupLoginButton = (Button) findViewById(R.id.signupLoginButton);
        loginModeTextView = (TextView) findViewById(R.id.loginModeTextView);

        redirectIfLoggedIn();

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
