package com.tretton37.example.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class UserActivity extends RoboActivity
{
    @InjectView(R.id.btnCallIntent) Button btnCallIntent;

    final int DEMO = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnCallIntent.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                // call intent in publisher application
                Intent intent = new Intent("com.tretton37.example.publisher.DEMO");
                startActivityForResult(intent, DEMO);
            }
        });
    }

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != Activity.RESULT_OK)
			return;

        if(requestCode == DEMO)
        {
            String value = (String)data.getExtras().get("value");

            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG);
        }
    }
}
