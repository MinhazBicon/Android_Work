package com.example.alertdilouge;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private Button button;
     private AlertDialog.Builder alertDialogBulider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        alertDialogBulider = new AlertDialog.Builder(MainActivity.this);

        // set title
        alertDialogBulider.setTitle(R.string.title);
        //set message
        alertDialogBulider.setTitle(R.string.message);
        //icon set
        alertDialogBulider.setIcon(R.drawable.qst);

        alertDialogBulider.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              //exit
                finish();

            }
        });
        alertDialogBulider.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              // do nothing stay current page
                dialog.cancel();

            }
        });
          alertDialogBulider.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You cancel it",Toast.LENGTH_SHORT).show();

            }
        });


        AlertDialog alertDialog= alertDialogBulider.create();
        alertDialog.show();


    }
}
