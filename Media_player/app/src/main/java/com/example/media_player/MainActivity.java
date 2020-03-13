package com.example.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaController2;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private ImageButton play,pause,next,prev;
     private MediaPlayer mediaPlayer1, mediaPlayer2;
     private MediaController2 mediaController2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playbutton_id);
        pause = findViewById(R.id.pausebutton_id);
        next = findViewById(R.id.nextbutton_id);
        prev = findViewById(R.id.previousbutton_id);

        mediaPlayer1 = MediaPlayer.create(this,R.raw.ghost_love_score);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.metalica_one);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.playbutton_id){
            if (mediaPlayer1!=null){
                mediaPlayer1.start();
                Toast.makeText(getApplicationContext(),"Song Start",Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId()==R.id.pausebutton_id){
            if (mediaPlayer1!=null || mediaPlayer2!=null){
                mediaPlayer1.pause();
                mediaPlayer2.pause();
                Toast.makeText(getApplicationContext(),"Song pause",Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId()==R.id.nextbutton_id){
            if (mediaPlayer2!=null){
                if (mediaPlayer1!=null || mediaPlayer2!=null) {
                    mediaPlayer1.pause();
                    mediaPlayer2.start();
                }
                Toast.makeText(MainActivity.this,"Playing next",Toast.LENGTH_SHORT).show();
            }
        }

        if (v.getId()==R.id.previousbutton_id){
            if (mediaPlayer1!=null || mediaPlayer2!=null){
                mediaPlayer2.pause();
                mediaPlayer1.start();
                Toast.makeText(getApplicationContext(),"playing prev",Toast.LENGTH_SHORT).show();
            }
        }




    }
}
