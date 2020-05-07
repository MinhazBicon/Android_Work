package com.example.sql_data_base1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name, age, gender, id;
    private Button save, display_data, update, delete;
    private MySQL_data_Base mySQL_data_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        delete = findViewById(R.id.delete_btn_id);
        name = findViewById(R.id.name_id);
        age = findViewById(R.id.age_id);
        gender = findViewById(R.id.gender_id);
        save = findViewById(R.id.save_btn_id);
        display_data = findViewById(R.id.display_btn_id);
        update = findViewById(R.id.update_btn_id);
        id = findViewById(R.id.ID_id);
        mySQL_data_base = new MySQL_data_Base(this);
        SQLiteDatabase database = mySQL_data_base.getWritableDatabase();

        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        save.setOnClickListener(this);
        display_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String Name = name.getText().toString();
        String Age = age.getText().toString();
        String Gender = gender.getText().toString();
        String Id = id.getText().toString();

        if (v == save) {
            if (Name.isEmpty()&&Age.isEmpty()&&Gender.isEmpty()){
                Toast.makeText(getApplicationContext(), "Insert Some Data First", Toast.LENGTH_SHORT).show();
            }else {
            long row_id = mySQL_data_base.insert_data(Name,Age,Gender);
            if (row_id == -1 ) {
                Toast.makeText(getApplicationContext(), "Data insert unsuccessful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), row_id + " Data insert successful", Toast.LENGTH_LONG).show();
            }}
            name.setText("");
            age.setText("");
            gender.setText("");
            id.setText("");
        }

       else if (v == display_data){
            Cursor DATA =  mySQL_data_base.Display_Data();

            if (DATA.getCount() == 0){
                //there is no data
                ShowData("Error ","No data found");
            }
            else {
            StringBuffer stringBuffer = new StringBuffer();
            while (DATA.moveToNext()){

                stringBuffer.append("ID: "+DATA.getString(0)+"\n");
                stringBuffer.append("Name: "+DATA.getString(1)+"\n");
                stringBuffer.append("Age: "+DATA.getString(2)+"\n");
                stringBuffer.append("Gender: "+DATA.getString(3)+"\n\n");
            }
              ShowData("Result Set",stringBuffer.toString());

            }
        }

        else if (v == update){
            if (Id.isEmpty() && Name.isEmpty() && Age.isEmpty() && Gender.isEmpty() ){
                Toast.makeText(getApplicationContext(),"Please enter all the information against ID to update",Toast.LENGTH_SHORT).show();
            }
            else {
             boolean updated = mySQL_data_base.update_data(Id,Name,Age,Gender);
              if (updated = true){
                Toast.makeText(getApplicationContext(),"Data is updated successfully",Toast.LENGTH_LONG).show();
                id.setText("");
                name.setText("");
                age.setText("");
                gender.setText("");
              }
               else {
                Toast.makeText(getApplicationContext(),"Data is not updated successfully",Toast.LENGTH_LONG).show();
            }
        }}

        else if (v == delete) {
          if (Id.isEmpty()){
              Toast.makeText(getApplicationContext(),"Please enter ID to delete",Toast.LENGTH_SHORT).show();
          }
          else {
            int value =  mySQL_data_base.Delete_Data(Id);
          if (value >0){
              Toast.makeText(getApplicationContext(),"Data is deleted successfully",Toast.LENGTH_LONG).show();
              id.setText("");
              name.setText("");
              age.setText("");
              gender.setText("");
          }
          else{
              Toast.makeText(getApplicationContext(),"Data is not deleted successfully",Toast.LENGTH_LONG).show();
          }
        }}
    }

    public void ShowData(String tittle, String data){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(tittle);
        builder.setMessage(data);
        builder.setNegativeButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });

        builder.show();

    }
}