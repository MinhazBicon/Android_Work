package com.example.sared_preference2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout_id);
        textView = findViewById(R.id.text_view_id);

        if (Load_color() != R.color.colorAccent_default){
            linearLayout.setBackgroundColor(Load_color());
        }
        if (Load_text() != "data not found"){
            textView.setText(Load_text());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.red_color_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent_red));
            Store_color(getResources().getColor(R.color.colorAccent_red));
            textView.setText("Red is selected as background");
            Store_text("last time you choose red");
        }

        if(item.getItemId() == R.id.blue_color_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent_blue));
            Store_color(getResources().getColor(R.color.colorAccent_blue));
            textView.setText("Blue is selected as background");
            Store_text("last time you choose green");
        }

        if(item.getItemId() == R.id.purple_color_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent_purple));
            Store_color(getResources().getColor(R.color.colorAccent_purple));
            textView.setText("Purple is selected as background ");
            Store_text("last time you choose purple");
        }

        if(item.getItemId() == R.id.light_green_color_id) {

            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent_light_green));
            Store_color(getResources().getColor(R.color.colorAccent_light_green));
            textView.setText("Light green is selected as background");
            Store_text("last time you choose light green");
        }
        return super.onOptionsItemSelected(item);
    }

    private void Store_color(int color){
        SharedPreferences preferences = getSharedPreferences("background_color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("color_id",color);
        editor.commit();
    }

    private void Store_text(String text){
        SharedPreferences preferences = getSharedPreferences("background_string", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text_id",text);
        editor.commit();
    }

    private String Load_text(){

        SharedPreferences preferences = getSharedPreferences("background_string",Context.MODE_PRIVATE);
        String selected_text = preferences.getString("text_id","data not found");
        return selected_text;
    }

    private int Load_color(){

        SharedPreferences preferences = getSharedPreferences("background_color",Context.MODE_PRIVATE);
        int select_color = preferences.getInt("color_id",getResources().getColor(R.color.colorAccent_default));
        return select_color;
    }
}
