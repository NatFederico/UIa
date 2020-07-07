package com.example.uia;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomIndexActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,b5,b6;
    private TextView title;
    private LinearLayout ln;
    RequestQueue queue;
    String URL = "http://uia.altervista.org/android/buttons.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_generated);
        init();
    }

    public void init(){
        ln = findViewById(R.id.buttons);
        title = (TextView)findViewById(R.id.textView);
        queue = Volley.newRequestQueue(this);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray users = response.getJSONArray("Buttons");
                    for(int i=0; i<users.length(); i++){
                        JSONObject user = users.getJSONObject(i);
                        String nome = user.getString("Name");
                        final String phrase = user.getString("Text");
                        Button button = new Button(getApplicationContext());
                        button.setText(nome);
                        button.setBackground(b1.getBackground());
                        button.setTextColor(b1.getTextColors());
                        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                        ln.addView(button,b1.getLayoutParams());
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                                i.putExtra("out",phrase);
                                startActivity(i);
                            }
                        });
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                title.append("Errore");
            }
        });
        queue.add(jsonObjectRequest);
        title.setText("Custom");
        b1.setText("+");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),InsertActivity.class);
                startActivity(i);
            }
        });
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
        b6.setVisibility(View.GONE);
    }
}
