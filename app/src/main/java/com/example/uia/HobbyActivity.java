package com.example.uia;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HobbyActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6,b;
    private LinearLayout buttons;
    private TextView title;
    private ViewGroup.LayoutParams params;

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
        buttons = (LinearLayout)findViewById(R.id.buttons);
        params = b1.getLayoutParams();

        title.setText("Attività");
        b1.setText("Gioca");
        b2.setText("TV");
        b3.setText("Studia");
        b4.setText("Uscire");
        b5.setText("Dormire");
        b6.setText("Leggere");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di giocare.");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di guardare qualcosa in TV/Netflix.");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di studiare.");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di uscire, andiamo?");
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di dormire.");
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho voglia di leggere, mi porti un libro?");
                startActivity(i);
            }
        });
    }
}
