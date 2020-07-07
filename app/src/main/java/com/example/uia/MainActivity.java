package com.example.uia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private Button macro1,macro2,macro3,macro4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        macro1 = (Button)findViewById(R.id.hobby);
        macro2 = (Button)findViewById(R.id.necessities);
        macro3 = (Button)findViewById(R.id.casa);
        macro4 = (Button)findViewById(R.id.custom);

        macro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HobbyActivity.class);
                startActivity(i);
            }
        });
        macro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a2 = new Intent(MainActivity.this, NecessitiesActivity.class);
                startActivity(a2);
            }
        });
        macro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a3 = new Intent(MainActivity.this, DiscussActivity.class);
                startActivity(a3);
            }
        });
        macro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a4 = new Intent(MainActivity.this, CustomIndexActivity.class);
                startActivity(a4);
            }
        });
    }
}
