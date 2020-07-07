package com.example.uia;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DiscussActivity extends AppCompatActivity {

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

        title.setText("Discuti");
        b1.setText("Perchè?");
        b2.setText("Non d'accordo");
        b3.setText("D'accordo");
        b4.setText("E' colpa tua");
        b5.setText("E' colpa mia");
        b6.setText("Ok");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Perchè dici?");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Non sono d'accordo con quello che dici.");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Sono d'accordo con quello che dici.");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","E' colpa tua!");
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Scusami, è colpa mia.");
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ok");
                startActivity(i);
            }
        });
    }
}
