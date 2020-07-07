package com.example.uia;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SnackActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_generated);
        init();
    }

    public void init(){
        title = (TextView)findViewById(R.id.textView);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);

        title.setText("Snack");
        b1.setText("Patatine");
        b2.setText("Cioccolata");
        b3.setText("Merendina");
        b4.setText("Biscotti");
        b5.setText("Gelato");
        b6.setText("Salato");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere delle patatine?");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere della cioccolata?");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere una merendina?");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere dei biscotti?");
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere del gelato?");
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SnackActivity.this, PhrasesActivity.class);
                i.putExtra("out","Ho fame, potrei avere del salato?");
                startActivity(i);
            }
        });
    }
}
