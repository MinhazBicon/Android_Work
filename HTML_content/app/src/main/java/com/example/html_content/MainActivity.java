package com.example.html_content;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     private WebView webView;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text  =  "<h1>This is my heading 1</h1>\n"+
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


                webView = findViewById(R.id.webview_id);
                button = findViewById(R.id.button);

                webView.loadDataWithBaseURL(null,text,"text/html","utf-8",null);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,Second_Activity.class);
                        startActivity(intent);
                    }
                });

    }
}
