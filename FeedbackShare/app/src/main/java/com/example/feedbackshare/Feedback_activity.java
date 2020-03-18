package com.example.feedbackshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback_activity extends AppCompatActivity implements View.OnClickListener {
     private EditText editText1, editText2;
     private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_activity);

        editText1 = findViewById(R.id.edit_text_id1);
        editText2 = findViewById(R.id.edit_text_id2);
        button1 = findViewById(R.id.button_id1);
        button2 = findViewById(R.id.button_id2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       try {
           String name = editText1.getText().toString();
           String message = editText2.getText().toString();
           if (v.getId()==R.id.button_id1){

               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/email");

               intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"minhazbicon@gmail.com"});
               intent.putExtra(Intent.EXTRA_SUBJECT,"FeedBack from App");
               intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name+ "\n Message: "+message);
               startActivity(intent.createChooser(intent,"FeedBack with"));
           }
           else if (v.getId()==R.id.button_id2){
               editText1.setText("");
               editText2.setText("");
           }

       } catch (Exception e){
           Toast.makeText(getApplicationContext(),"Exception: "+e,Toast.LENGTH_LONG).show();
       }
       }
    }

