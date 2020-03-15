package com.example.menu_actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.share_id) {
            Toast.makeText(getApplicationContext(), "Share is clicked", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String sub = "This is my subject";
            String body = "This is my new Body.\n com.example.menu_actionbar";

            intent.putExtra(Intent.EXTRA_SUBJECT, sub);
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(intent, "share with..."));
            }

        else if (item.getItemId()==R.id.Delete_id){
            Toast.makeText(MainActivity.this,"Deleted task",Toast.LENGTH_SHORT).show();
            }
        else if (item.getItemId()==R.id.Copy_id){
            Toast.makeText(getApplicationContext(),"Copied task",Toast.LENGTH_SHORT).show();
            }
        else if (item.getItemId()==R.id.Extra_id){
            Toast.makeText(getApplicationContext(),"No Extra task",Toast.LENGTH_SHORT).show();
            }

        return super.onOptionsItemSelected(item);
    }
}
