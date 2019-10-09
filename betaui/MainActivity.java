package com.example.betaui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFindBus(View view) {
        Log.d(LOG_TAG, "Button Clicked!");

        Intent intent = new Intent(this, FindBus.class);
        startActivity(intent);
    }

    public void launchHelp(View view) {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, HelpMe.class);
        startActivity(intent);
    }

    public void launchAbout(View view) {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
}
