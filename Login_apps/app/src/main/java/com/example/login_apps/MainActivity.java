package com.example.login_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button login_btn;
     private TextView attempted_view;
     private EditText user_name, password;
     private int count = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = findViewById(R.id.login_btn);
        attempted_view = findViewById(R.id.attempted);
        user_name = findViewById(R.id.user_name);
        password = findViewById(R.id.password);

        attempted_view.setText("your attempt left "+ count);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name_text = user_name.getText().toString();
                String password_text = password.getText().toString();

                if (user_name_text.equals("Bicon") && password_text.equals("password")){
                    Intent intent = new Intent(MainActivity.this, Profile.class);
                    startActivity(intent);
                }
                else{
                    count--;
                    attempted_view.setText("your attempt left"+ count);
                    if(count==0){
                        login_btn.setEnabled(false);
                    }
                }
            }
        });
    }
}
