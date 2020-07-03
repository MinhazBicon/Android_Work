package com.example.sql_data_base2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button signUp_Store_dataBase;
    private EditText name,email,password,re_password, userName;
    private UserDetails userDetails;
    private MySQL_Data_Base mySQL_data_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        signUp_Store_dataBase = findViewById(R.id.signUp_btn_id_Data_Base);
        name = findViewById(R.id.name_id);
        email = findViewById(R.id.email_id);
        userName = findViewById(R.id.user_name_id_for_signUp);
        password = findViewById(R.id.password_id_for_signUp);
        re_password = findViewById(R.id.re_password_id);

        signUp_Store_dataBase.setOnClickListener(this);

        userDetails = new UserDetails();
        mySQL_data_base = new MySQL_Data_Base(this);

    }

    @Override
    public void onClick(View v) {
        String Name = name.getText().toString();
        String Email = email.getText().toString();
        String UserName = userName.getText().toString();
        String Password = password.getText().toString();
        String Re_password = re_password.getText().toString();

        userDetails.setName(Name);
        userDetails.setEmail(Email);
        userDetails.setUserName(UserName);
        userDetails.setPassword(Password);

        if (password.getText().toString().equals(re_password.getText().toString())){

            if (Name.isEmpty() && Email.isEmpty() && UserName.isEmpty()) {

                Toast.makeText(getApplicationContext(),"Please enter your details",Toast.LENGTH_SHORT).show();
            }

            else {
                long rowId = mySQL_data_base.Insert_Data(userDetails);

                if (rowId>0){
                    Toast.makeText(getApplicationContext(),rowId+" SignUp is successfully done",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"SignUp failed",Toast.LENGTH_LONG).show();
                }

            }
            name.setText("");
            userName.setText("");
            email.setText("");
            password.setText("");
            re_password.setText("");

        }
        else {

            Toast.makeText(getApplicationContext(),"Re-Type your Password",Toast.LENGTH_SHORT).show();
            password.setText("");
            re_password.setText("");

    }
    }
    }

