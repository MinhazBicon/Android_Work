package com.example.share_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button save, load;
    private EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view_id);
        save = findViewById(R.id.save_button);
        load = findViewById(R.id.load_button);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == save) {

            String user_name = name.getText().toString();
            String Password = password.getText().toString();
            //(user_name.equal("") && password.equal(""))
                        //or
            if (user_name.isEmpty() && Password.isEmpty()) {

                Toast.makeText(getApplicationContext(), "Please enter Something", Toast.LENGTH_SHORT).show();
            }
            else {

                // Writing data in Shared Preference
                SharedPreferences preferences = getSharedPreferences("details", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user_name_key", user_name);
                editor.putString("Password_key", Password);
                editor.commit();
                name.setText("");
                password.setText("");
                Toast.makeText(getApplicationContext(), "Your data is saved", Toast.LENGTH_SHORT).show();
            }
        }

        else if (v == load) {

            // read data from Shared Preference
            SharedPreferences preferences = getSharedPreferences("details", Context.MODE_PRIVATE);
            if (preferences.contains("user_name_key") && preferences.contains("Password_key")) {

                String username = preferences.getString("user_name_key", "user name not found");
                String password = preferences.getString("Password_key", "password not found");
                textView.setText(username + "\n" + password);


            }
        }
    }
 }