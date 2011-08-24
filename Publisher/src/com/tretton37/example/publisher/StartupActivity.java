package com.tretton37.example.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * User: Fredrik / 2011-08-24
 */
public class StartupActivity extends RoboActivity {
    @InjectView(R.id.salEdit) EditText edit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_activity_layout);

        edit.setText("Ninja!");
    }
}