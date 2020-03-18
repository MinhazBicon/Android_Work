package com.example.feedbackshare;

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
        if (item.getItemId()==R.id.Delete){
            Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.Share){
            Toast.makeText(getApplicationContext(),"Share item",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String suject = "Share item";
            String body = "Share it with your frienfd & family.\n Chose Share with via...";

            intent.putExtra(Intent.EXTRA_SUBJECT,suject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share"));
        }

        else if (item.getItemId()==R.id.feedback){
            Toast.makeText(getApplicationContext(),"Feedback",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Feedback_activity.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.Delete){
            Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
            }
        else if (item.getItemId()==R.id.Move){
            Toast.makeText(getApplicationContext(),"Moved",Toast.LENGTH_SHORT).show();
            }
        else if (item.getItemId()==R.id.Select){
            Toast.makeText(getApplicationContext(),"Select something",Toast.LENGTH_SHORT).show();
            }
        else if (item.getItemId()==R.id.Setting){
            Toast.makeText(getApplicationContext(),"new Setting",Toast.LENGTH_SHORT).show();
            }

        return super.onOptionsItemSelected(item);
    }
}
