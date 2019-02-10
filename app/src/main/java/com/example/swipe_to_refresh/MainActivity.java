package com.example.swipe_to_refresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;

    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout  = (SwipeRefreshLayout) findViewById(R.id.Swipe);
        textView = (TextView) findViewById(R.id.tvSwipe);

        //swipeRefreshLayout.setOnRefreshListener(this);

        textView.setText("Total Number = 0");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                number++;
                textView.setText("Total number = "+number);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipeRefreshLayout.setRefreshing(false);            //to stop refreshing
                    }
                }, 1000);
            }
        });

    }

    @Override
    public void onRefresh() {
        // write toast if you want
    }
}
