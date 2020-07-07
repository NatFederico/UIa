package com.example.uia;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DrinkActivity extends AppCompatActivity {

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

        title.setText("Bibite");
        b1.setText("Acqua");
        b2.setText("Coca Cola");
        b3.setText("Succo");
        b4.setText("Birra");
        b5.setText("The");
        b6.setText("Tisana");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere dell'acqua?");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere della coca cola?");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere del succo?");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere della birra?");
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere del the?");
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho sete, potrei avere una tisana?");
                startActivity(i);
            }
        });
    }
}
