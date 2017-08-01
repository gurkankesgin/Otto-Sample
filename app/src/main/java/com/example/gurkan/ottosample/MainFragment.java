package com.example.gurkan.ottosample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

/**
 * Created by gurkan on 9.1.2016.
 */
public class MainFragment extends Fragment {

    public TextView counter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ApplicationClass.busProvider.register(this);
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        view.findViewById(R.id.counter);

        counter = (TextView) view.findViewById(R.id.counter);

        return view;
    }

    @Subscribe
   public void callingMessage(Message message) {

        String countertype = message.count;

        if (countertype.equals("minus")) {

            int counterInt = Integer.parseInt(counter.getText().toString());
            counter.setText(String.valueOf(--counterInt));

        } else if (countertype.equals("plus")) {
            int counterInt = Integer.parseInt(counter.getText().toString());
            counter.setText(String.valueOf(++counterInt));
        }

    }
}
