package com.example.spinner1;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      private Button button;
      private TextView textView;
      private Spinner spinner;
      private String[] item_name;
      private String[] description;
      private int[] image={R.drawable.biohazard,R.drawable.environment,R.drawable.gasoline,
              R.drawable.magnet,R.drawable.nuclear,R.drawable.radioactive,R.drawable.science,
          R.drawable.security,R.drawable.waste,R.drawable.power};
      private boolean first_selection = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_id);
        textView = findViewById(R.id.textview_id1);

        spinner = findViewById(R.id.spinner_id);
        item_name = getResources().getStringArray(R.array.item);
        description = getResources().getStringArray(R.array.description);

        final CustomAdapter adapter = new CustomAdapter(this,image,item_name,description);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                if(first_selection==true){
                    first_selection=false;

                }
                else {
                    Toast.makeText(getApplicationContext(),item_name[position]+" "+"is selected",Toast.LENGTH_LONG).show();
                }
                button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value0 = item_name[position];
                    String value1 = description[position];
                    textView.setText("You select:::"+"\n"+value0+"\n"+value1);
                }
            });


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    }
}
