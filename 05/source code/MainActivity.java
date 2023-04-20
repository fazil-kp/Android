package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView timeDisplay;
    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private long startTime = 0L;
    private Handler handler = new Handler();
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeDisplay = findViewById(R.id.time_display);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);
        resetButton = findViewById(R.id.reset_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
                startTime = 0L;
                timeDisplay.setText("00:00:00");
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });

        runnable = new Runnable() {
            @Override
            public void run() {
                long millis = SystemClock.uptimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                int milliseconds = (int) (millis % 1000);
                String timeString = String.format("%02d:%02d:%02d", minutes, seconds, milliseconds / 10);
                timeDisplay.setText(timeString);
                handler.postDelayed(this, 0);
            }
        };

        stopButton.setEnabled(false); 
    }
}