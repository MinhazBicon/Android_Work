hpackage com.example.intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Secondactivity extends AppCompatActivity {
     private EditText editText;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        editText = findViewById(R.id.editxtid);
        button = findViewById(R.id.button1id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = editText.getText().toString();

                Intent intent = new Intent(Secondactivity.this,MainActivity.class);
                intent.putExtra("tag",value);
                setResult(1,intent);
                finish();

            }
        });

    }
}
