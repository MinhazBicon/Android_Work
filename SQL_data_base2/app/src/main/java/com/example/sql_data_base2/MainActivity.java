package com.example.sql_data_base2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login, signUp;
    private EditText user_name_signIn, password_signIn;
    private MySQL_Data_Base mySQL_data_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login_btn_id);
        signUp = findViewById(R.id.signUp_btn_id);
        user_name_signIn = findViewById(R.id.user_name_id_for_signIn);
        password_signIn = findViewById(R.id.password_id_for_signIn);

        login.setOnClickListener(this);
        signUp.setOnClickListener(this);

         mySQL_data_base = new MySQL_Data_Base(this);
         SQLiteDatabase sqLiteDatabase = mySQL_data_base.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        String userName = user_name_signIn.getText().toString();
        String password = password_signIn.getText().toString();

        if (v == signUp){
            Intent intent = new Intent(MainActivity.this,SignUp_Activity.class);
            startActivity(intent);
        }
        else if (v == login){
            if (userName.isEmpty() && password.isEmpty()){
                Toast.makeText(getApplicationContext(),"Enter your login information please",Toast.LENGTH_SHORT).show();
            }
            else {
            Boolean result = mySQL_data_base.Match_Identity(userName, password);
            if (result == true){
                Intent intent = new Intent(MainActivity.this, New_Profile.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"Incorrect User or Password",Toast.LENGTH_SHORT).show();

            }


        }
            password_signIn.setText("");
            user_name_signIn.setText("");

        }
    }
}
