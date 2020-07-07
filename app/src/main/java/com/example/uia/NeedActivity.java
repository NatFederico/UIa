package com.example.uia;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NeedActivity extends AppCompatActivity {

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

        title.setText("Ho bisogno");
        b1.setText("Aiuto");
        b2.setText("Uscire");
        b3.setText("Solo");
        b4.setText("Compagnia");
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Mi sto trovando in difficoltà, mi puoi dare una mano?");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho bisogno di uscire.");
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho bisogno di stare da solo per un po'.");
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                i.putExtra("out","Ho bisogno di compagnia, puoi stare con me?");
                startActivity(i);
            }
        });
    }
}
