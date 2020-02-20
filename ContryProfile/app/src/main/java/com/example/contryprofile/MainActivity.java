package com.example.contryprofile;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bd, us, omn, ger, frnc, chn, eng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = findViewById(R.id.bd);
        us = findViewById(R.id.us);
        ger = findViewById(R.id.ger);
        omn = findViewById(R.id.omn);
        chn = findViewById(R.id.chn);
        frnc = findViewById(R.id.frnc);
        eng = findViewById(R.id.eng);

        bd.setOnClickListener(this);
        us.setOnClickListener(this);
        ger.setOnClickListener(this);
        chn.setOnClickListener(this);
        frnc.setOnClickListener(this);
        omn.setOnClickListener(this);
        eng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bd) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "Bangladesh");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to Bangladesh", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.us) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "USA");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Trump are you there??", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.ger) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "Germany");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to Germany", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.omn) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "Oman");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to Oman", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.frnc) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "France");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to France", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.chn) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "China");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to Chorona Virus", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.eng) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("tag", "England");
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to England", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setIcon(R.drawable.problem);
        alertDialogBuilder.setTitle(R.string.alert_title);
        alertDialogBuilder.setMessage(R.string.alert_message);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }


}