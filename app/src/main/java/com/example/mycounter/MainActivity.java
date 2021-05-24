package com.example.mycounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private long initialValue = 0;
    TextView textView;
    Button start,stop,reset;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        reset = findViewById(R.id.reset);

        start.setOnClickListener(v->{
            startCounter.run();
        });
        stop.setOnClickListener( v->{
            handler.removeCallbacks(startCounter);
        });
        reset.setOnClickListener(v -> {
            handler.removeCallbacks(startCounter);
            initialValue = 0;
            textView.setText(String.valueOf(initialValue));
        });
    }
    Runnable startCounter =  new Runnable(){
        @Override
        public void run(){
            textView.setText(String.valueOf(++initialValue));
            handler.postDelayed(this,1000);
        }
    };

}