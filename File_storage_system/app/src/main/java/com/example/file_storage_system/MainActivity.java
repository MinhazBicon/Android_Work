package com.example.file_storage_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
     private EditText note;
     private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = findViewById(R.id.note_id);
        save = findViewById(R.id.save_btn_id);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = note.getText().toString();

                if (text.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Nothing to save",Toast.LENGTH_LONG).show();
                }
                else {
                    write_file(text);
                }
            }
        });

        read_file();
    }

    public void write_file(String text){

        try {
            FileOutputStream fileOutputStream = openFileOutput("Note.txt", Context.MODE_PRIVATE);
            try {

                fileOutputStream.write(text.getBytes());
                fileOutputStream.close();

                Toast.makeText(getApplicationContext(),"Your text is saved",Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void read_file(){
        try {

            FileInputStream fileInputStream = openFileInput("Note.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while ((line = bufferedReader.readLine()) !=null){
                stringBuffer.append(line +"\n");
            }

            note.setText(stringBuffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
