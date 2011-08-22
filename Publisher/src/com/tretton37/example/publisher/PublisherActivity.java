package com.tretton37.example.publisher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * User: Fredrik / 2011-08-22
 */
public class PublisherActivity extends RoboActivity {

    @InjectView(R.id.palTextView) TextView palTextView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publisher_activity_layout);

        this.palTextView.setText("Hai!");
    }
}