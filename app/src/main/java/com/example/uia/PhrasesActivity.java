package com.example.uia;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class PhrasesActivity extends AppCompatActivity {

    private TextView phrase;
    private Button home;
    private TextToSpeech voice;
    private ImageButton speech,wh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        init();
    }
    public void init(){
        phrase = (TextView)findViewById(R.id.textView);
        home = (Button)findViewById(R.id.home);
        speech = (ImageButton)findViewById(R.id.speech);
        wh = (ImageButton)findViewById(R.id.wh);
        Intent reciver = getIntent();
        final String out = reciver.getStringExtra("out");
        phrase.setText(out);
        voice = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int result = voice.setLanguage(Locale.ITALIAN);
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS", "Language not supported");
                    }
                    else{
                        speech.setEnabled(true);
                    }
                }
                else{
                    Log.e("TTS", "Initialization failed");
                }
            }
        });
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        wh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msg = new Intent();
                msg.setAction(Intent.ACTION_SEND);
                msg.putExtra(Intent.EXTRA_TEXT, out);
                msg.setType("text/plain");
                msg.setPackage("com.whatsapp");
                startActivity(msg);
            }
        });
    }

    private void speak(){
        String text = phrase.getText().toString();
        voice.setPitch(1);
        voice.setSpeechRate(1);
        voice.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    protected void onDestroy() {
        if(voice!=null){
            voice.stop();
            voice.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onBackPressed () {
    }
}
