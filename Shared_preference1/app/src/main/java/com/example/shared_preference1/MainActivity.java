package com.example.shared_preference1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button score_up, score_down;
    private TextView Score_show;
    private  int Score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score_up = findViewById(R.id.score_up_btn);
        score_down = findViewById(R.id.score_down_btn);
        Score_show = findViewById(R.id.text_view_id);

        if (Load_Score() != 0){
            Score_show.setText("Score: "+Load_Score());
        }

        score_up.setOnClickListener(this);
        score_down.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.score_up_btn){
            Score = Score + 5;
            Score_show.setText("Score: "+Score);
            Save_Score(Score);
        }

        else if (v.getId()==R.id.score_down_btn){
            Score = Score - 5;
            Score_show.setText("Score: "+Score);
            Save_Score(Score);
        }
    }

    private void Save_Score(int Score){
        SharedPreferences preferences = getSharedPreferences("Score_value", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("last_score",Score);
        editor.commit();

    }

  private int Load_Score(){
        SharedPreferences preferences = getSharedPreferences("Score_value",Context.MODE_PRIVATE);
        int Score = preferences.getInt("last_score",0);
        return Score;
    }

}
