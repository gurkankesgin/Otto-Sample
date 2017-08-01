package com.example.gurkan.ottosample;

import android.app.*;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public View plus;
    public View minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationClass.busProvider.register(this);
        createFragment();
        initialize();
        setListener();

    }

    private void setListener() {

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationClass.busProvider.post(new Message("plus"));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationClass.busProvider.post(new Message("minus"));
            }
        });
    }

    private void initialize() {
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
    }

    private void createFragment() {
        FragmentManager manager = getSupportFragmentManager();
        MainFragment fragment = new MainFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,fragment,"mainFragment");
        transaction.commit();
    }
}
