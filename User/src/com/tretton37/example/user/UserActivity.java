package com.tretton37.example.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class UserActivity extends RoboActivity {
    @InjectView(R.id.btnCallIntent)
    Button btnCallIntent;
    @InjectView(R.id.btnCallCameraIntent)
    Button btnCallCameraIntent;
    @InjectView(R.id.btnCallUnknownIntent)
    Button btnCallUnknownInten;

    final int DEMO = 0;
    final int LOLS = 1;
    final int CAMERA = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnCallIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // call intent in publisher application
                Intent intent = new Intent("com.tretton37.example.publisher.DEMO");
                startActivityForResult(intent, DEMO);
            }
        });

        // Add btn for camera intent & unkown intent (com.tretton37.example.publisher.LOLS)
        btnCallUnknownInten.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("com.tretton37.example.publisher.LOLS");
                startActivityForResult(intent, LOLS);
            }
        });

        btnCallCameraIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("User", String.valueOf(requestCode));
        Log.i("User", String.valueOf(resultCode));

        if (resultCode != Activity.RESULT_OK)
            return;

        switch (requestCode) {
            case DEMO:
                String value = (String) data.getExtras().get("value");
                Log.i("User", "Publisher said: " + value);
                Toast.makeText(this, "Publisher said: " + value, Toast.LENGTH_SHORT).show();
                break;

            case CAMERA:
                break;

            default:
                Toast.makeText(this, "default!?", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
