package com.tretton37.example.publisher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * User: Fredrik / 2011-08-22
 */
public class PublisherActivity extends RoboActivity {

    @InjectView(R.id.palTextView) TextView palTextView;
    @InjectView(R.id.btnRespond) Button btnRespond;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publisher_activity_layout);

        btnRespond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //To change body of implemented methods use File | Settings | File Templates.
                // return intent
            }
        });

        Intent intent = this.getIntent();
        if(intent != null)
        {
            String action = intent.getAction();
            if(action.equals("com.tretton37.example.publisher.DEMO"))
            {
                // do stuff ?
            }
        }
    }
}