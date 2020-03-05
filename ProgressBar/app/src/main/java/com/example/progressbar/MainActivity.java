package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar1, progressBar2;
    int progress1, progress2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar1 = findViewById(R.id.progress_id1);
        progressBar2 = findViewById(R.id.progress_id2);

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork1();
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork2();
            }
        });

        thread1.start();
        thread2.start();
    }



    public void doWork1() {
        for (progress1=10; progress1<=100; progress1= progress1+10){
        try {
            Thread.sleep(1000);
            progressBar1.setProgress(progress1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    }

    public void doWork2() {
        for (progress2=10; progress2<=100; progress2= progress2+15){
            try {
                Thread.sleep(1500);
                progressBar2.setProgress(progress2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}

    }

}