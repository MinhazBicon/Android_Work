package com.example.html_content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
     private TextView textView;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        String my_text  =  "<h1>This is my heading 1</h1>\n"+
                "<h2>This is my heading 2</h2>\n"+
                "<h3>This is my heading 3</h3>\n"+
                "<p>This is my paragraph</p>\n"+
                "<p><b>This is my paragraph(bold)</b></p>\n"+
                "<p><u>This is my paragraph with underline</u></p>\n"+
                "<p><i>This is my paragraph(Italic)</i></p>\n"+
                "My order List \n"+
                "<ol>\n"+
                "<li> C </li>\n"+
                "<li> Java </li>\n"+
                "<li> Python </li>\n"+
                "<li> Rube</li>\n"+
                "</ol>\n "+
                "(a<sup>3</sup>+b<sup>3</sup>) = (a+b)(a<sup>2</sup>-ab+b<sup>2</sup>)";

        button = findViewById(R.id.button_id);
        textView = findViewById(R.id.textview_id);

        textView.setText(Html.fromHtml(my_text));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
