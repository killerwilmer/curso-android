package com.killerwilmer.numbershapes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }

    }

    public void testNumberClick(View view) {

        String message = "";
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);

        if (numberEditText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(numberEditText.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is both triangular and square!";
                } else {
                    message = myNumber.number + " is square, but not triangular";
                }
            } else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is triangular but not square.";
                } else {
                    message = myNumber.number + " is neither square nor triangular";
                }
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
