package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private EditText editText0,editText1;
     private Button addbutton,subbutton,mullbutton,divbutton;
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText0= findViewById(R.id.editText1);
        editText1= findViewById(R.id.editText2);
        addbutton= findViewById(R.id.buton0);
        subbutton= findViewById(R.id.buton1);
        mullbutton= findViewById(R.id.buton2);
        divbutton= findViewById(R.id.buton3);
        textView= findViewById(R.id.txtview);

        addbutton.setOnClickListener(this);
        subbutton.setOnClickListener(this);
        mullbutton.setOnClickListener(this);
        divbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {

            String number1 = editText0.getText().toString();
            String number2 = editText1.getText().toString();

            //Converting String to double

            double numb1 = Double.parseDouble(number1);
            double numb2 = Double.parseDouble(number2);

            if (v.getId() == R.id.buton0) {
                double sum = numb1 + numb2;
                textView.setText("Result is:: " + sum);
            }
            if (v.getId() == R.id.buton1) {
                double sum = numb1 - numb2;
                textView.setText("Result is::: " + sum);
            }
            if (v.getId() == R.id.buton2) {
                double sum = numb1 * numb2;
                textView.setText("Result is::: " + sum);
            }
            if (v.getId() == R.id.buton3) {
                double sum = numb1 / numb2;
                textView.setText("Result is::: " + sum);
            }
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Please enter two numbers",Toast.LENGTH_SHORT).show();
        }


    }
}
