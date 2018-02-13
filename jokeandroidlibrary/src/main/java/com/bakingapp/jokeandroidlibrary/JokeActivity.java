package com.bakingapp.jokeandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static String KEY = "KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textview = (TextView) findViewById(R.id.joke_tv);
        String JokeResult = null;

        Intent intent = getIntent();


        JokeResult = intent.getStringExtra(getString(R.string.jokecontent));


        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("Here is a joke!");
        }
    }
}
