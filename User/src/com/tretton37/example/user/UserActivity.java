package com.tretton37.example.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class UserActivity extends RoboActivity
{
    @InjectView(R.id.btnCallIntent) Button btnCallIntent;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnCallIntent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {

            }
        });
    }
}
