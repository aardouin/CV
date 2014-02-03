package com.aardouin.cv.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.aardouin.cv.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    public static final int DELAY = 2000;
    private ViewGroup container;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        container = (ViewGroup)findViewById(R.id.container);
    }

    @Override
    protected void onResume() {
        super.onResume();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                goNext();
            }
        }, DELAY);


    }

    private void goNext() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }
}
