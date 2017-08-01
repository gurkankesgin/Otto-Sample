package com.example.gurkan.ottosample;

import com.squareup.otto.Bus;

/**
 * Created by gurkan on 9.1.2016.
 */
public class ApplicationClass extends android.app.Application {

    public static Bus busProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        busProvider = new Bus();
    }
}
