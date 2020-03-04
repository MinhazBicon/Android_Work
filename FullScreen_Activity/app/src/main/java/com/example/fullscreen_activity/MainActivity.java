package com.example.fullscreen_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
       private ProgressBar progressBar;
       private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove the title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //remove notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_id);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Work();
            }
        });

        thread.start();
    }

    public void Work(){
          for (progress=0; progress<=5; progress++)
        try {
            Thread.sleep(1000);
            progressBar.setProgress(progress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
