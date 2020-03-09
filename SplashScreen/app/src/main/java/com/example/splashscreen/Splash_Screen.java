package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash_Screen extends AppCompatActivity {
     private ProgressBar progressBar;
     int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash__screen);

        progressBar = findViewById(R.id.progress_id);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                DoProgress();
                StartAPP();
            }
        });

        thread.start();
    }

    public void DoProgress(){
        for (progress=0;progress<=100; progress=progress+10){
        try {
            Thread.sleep(800);
            progressBar.setProgress(progress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    }

    public void StartAPP(){
        Intent intent = new Intent(Splash_Screen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
