package com.tretton37.example.user;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.List;

public class UserActivity extends RoboActivity {
    @InjectView(R.id.btnCallIntent)
    Button btnCallIntent;
    @InjectView(R.id.btnCallCameraIntent)
    Button btnCallCameraIntent;
    @InjectView(R.id.btnCallUnknownIntent)
    Button btnCallUnknownInten;
    @InjectView(R.id.btnCallUnknownIntentWithoutCrash)
    Button btnCallUnknownIntentWithoutCrash;
    @InjectView(R.id.ivCameraImage)
    ImageView ivCameraImage;

    final int DEMO = 0;
    final int LOLS = 1;
    final int CAMERA = 2;

    final String LOLSIntent = "com.tretton37.example.publisher.LOLS";
    final String  DEMOIntent = "com.tretton37.example.publisher.DEMO";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);



        setupButtons();
    }

    private void setupButtons() {
        btnCallIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DEMOIntent);
                startActivityForResult(intent, DEMO);
            }
        });

        btnCallUnknownInten.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(LOLSIntent);
                startActivityForResult(intent, LOLS);
            }
        });

        btnCallUnknownIntentWithoutCrash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(isIntentPublished(LOLSIntent)) {
                    Intent intent = new Intent(LOLSIntent);
                    startActivityForResult(intent, UserActivity.this.LOLS);
                }
            }
        });

        btnCallCameraIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
            }
        });
    }

    private boolean isIntentPublished(String Intent) {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(Intent);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("User", String.valueOf(requestCode));
        Log.i("User", String.valueOf(resultCode));

        if (resultCode != Activity.RESULT_OK) {
            Log.i("User", "meh!");
            return;
        }
        switch (requestCode) {
            case DEMO:
                String value = (String) data.getExtras().get("value");
                Log.i("User", "Publisher said: " + value);
                Toast.makeText(this, "Publisher said: " + value, Toast.LENGTH_SHORT).show();
                break;

            case CAMERA:
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                ivCameraImage.setImageBitmap(photo);
                break;

            default:
                Toast.makeText(this, "default!?", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
