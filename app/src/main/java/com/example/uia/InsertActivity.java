package com.example.uia;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


public class InsertActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner macros,categories;
    private TextView ok;
    private EditText name,text;
    private String macroSelected,categorySelected;
    private Button send;
    String apiLocation="http://uia.altervista.org/android/add.php";
    RequestQueue request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        spinAndSend();
    }
    private void spinAndSend(){
        ok = findViewById(R.id.ok);
        macros = findViewById(R.id.macros);
        categories = findViewById(R.id.categorie);
        name = findViewById(R.id.name);
        text = findViewById(R.id.text);
        request = Volley.newRequestQueue(this);
        send = (Button) findViewById(R.id.invio);

        ArrayAdapter<CharSequence> adapterMacro = ArrayAdapter.createFromResource(this,R.array.macros,R.layout.spinner_choice);
        adapterMacro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        macros.setAdapter(adapterMacro);
        macros.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this,R.array.categories,R.layout.spinner_choice);
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories.setAdapter(adapterCat);
        categories.setOnItemSelectedListener(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setText("OK");
                StringRequest stringRequest=new StringRequest(Request.Method.POST, apiLocation, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ok.setText("salvato");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Errore nel Salvataggio",Toast.LENGTH_LONG);
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        translate();
                        Map<String,String> params = new HashMap<>();
                        params.put("IDC",macroSelected);
                        params.put("Name",name.getText().toString());
                        params.put("Text",text.getText().toString());
                        return params;
                    }
                };
                request.add(stringRequest);
            }
        });
    }
    private void translate(){
        String[] macrosID = {"Attività", "Necessità", "Discuti"};
        String[] catID = {"-----","Fame", "Sete", "Sentimenti","Ho bisogno"};
        for(int i = 0; i<macrosID.length; i++){
            if(macroSelected==macrosID[i]){
                macroSelected=Integer.toString(i);
            }
        }
        for(int i = 0; i<catID.length; i++){
            if(categorySelected==catID[i]){
                categorySelected=Integer.toString(i);
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.macros){
            //Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            macroSelected=parent.getItemAtPosition(position).toString();
        }
        if(parent.getId()==R.id.categorie){
            //Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            categorySelected=parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
