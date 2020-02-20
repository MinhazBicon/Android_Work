package com.example.contryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
     private ImageView imageView;
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        imageView = findViewById(R.id.imageviewid);
        textView = findViewById(R.id.textviewid);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){

            String country = bundle.getString("tag");
            showDetails(country);
        }
    }

    void showDetails(String country){

        if(country.equals("Bangladesh")){
            imageView.setImageResource(R.drawable.bang);
            textView.setText(R.string.bangladesh_txt);
        }
           if(country.equals("USA")){
            imageView.setImageResource(R.drawable.us);
            textView.setText(R.string.usa_txt);
        }
           if(country.equals("Germany")){
            imageView.setImageResource(R.drawable.german);
            textView.setText(R.string.germany_txt);
        }
           if(country.equals("China")){
            imageView.setImageResource(R.drawable.ch);
            textView.setText(R.string.china_txt);
        }
           if(country.equals("Oman")){
            imageView.setImageResource(R.drawable.om);
            textView.setText(R.string.oman_txt);
        }
           if(country.equals("France")){
            imageView.setImageResource(R.drawable.paris);
            textView.setText(R.string.france_txt);
        }
           if(country.equals("England")){
            imageView.setImageResource(R.drawable.en);
            textView.setText(R.string.england_txt);
        }

    }
}

