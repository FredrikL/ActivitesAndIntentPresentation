package com.tretton37.example.publisher;

import android.app.Application;
import com.google.inject.Module;
import roboguice.application.RoboApplication;

import java.util.List;

/**
 * User: Fredrik / 2011-08-22
 */
public class PublisherApplication extends RoboApplication {
     protected void addApplicationModules(List<Module> modules) {
        //modules.add(new PublisherModule());
    }
}
