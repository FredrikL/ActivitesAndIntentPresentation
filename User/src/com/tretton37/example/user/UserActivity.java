package com.tretton37.example.user;

import android.os.Bundle;
import roboguice.activity.RoboActivity;

public class UserActivity extends RoboActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
