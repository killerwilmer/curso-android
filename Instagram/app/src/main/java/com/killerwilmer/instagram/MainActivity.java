package com.killerwilmer.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    EditText usernameEditText;
    EditText passwordEditText;
    TextView changeSignUpModeTextView;
    Button signUpButton;
    ConstraintLayout constraintLayout;

    Boolean signUpModeActive = true;

    public void showUserList() {
        Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.changeSignUpModeTextView) {
            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("Login");
                changeSignUpModeTextView.setText("or, Sign Up");
            } else {
                signUpModeActive = true;
                signUpButton.setText("Sign Up");
                changeSignUpModeTextView.setText("or, Login");
            }
        } else if (v.getId() == R.id.constraintLayout) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void signUp(View view) {

        if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")) {
            Toast.makeText(this, "A username and password are required.", Toast.LENGTH_SHORT).show();
        } else {

            if (signUpModeActive) {
                ParseUser user = new ParseUser();

                user.setUsername(usernameEditText.getText().toString());
                user.setPassword(passwordEditText.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("signUp", "Successful");
                            showUserList();
                        } else {
                            Log.i("error", e.toString());
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Log.i("Sign Up", "Login Successful");
                            showUserList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Instagram");

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        changeSignUpModeTextView = (TextView) findViewById(R.id.changeSignUpModeTextView);
        signUpButton = (Button) findViewById(R.id.signUpButton);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        constraintLayout.setOnClickListener(this);

        changeSignUpModeTextView.setOnClickListener(this);

        passwordEditText.setOnKeyListener(this);

        if (ParseUser.getCurrentUser() != null) {
            showUserList();
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == event.ACTION_DOWN) {
            signUp(v);
        }
        return false;
    }
}
