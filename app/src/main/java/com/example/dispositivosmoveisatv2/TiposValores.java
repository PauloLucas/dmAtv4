package com.example.dispositivosmoveisatv2;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.dispositivosmoveisatv1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class TiposValores extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Valores> valores;
    String JSON_URL = "https://my-json-server.typicode.com/paulolucas/atividade2DispositivosMoveis/Valores";
    AdapterValores adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_valores);
        recyclerView = findViewById(R.id.valores_list);
        setTitle("Valores");
        valores = new ArrayList<>();

        extrair();
    }

    private void extrair() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject Object = response.getJSONObject(i);
                        Valores valores1 = new Valores();
                        valores1.setTipo(Object.getString("Tipo").toString());
                        valores1.setMedida(Object.getString("Medida").toString());
                        valores1.setValor(Object.getString("Valor").toString());
                        valores.add(valores1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterValores(getApplicationContext(), valores);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener(){
            @Override

            public void onErrorResponse(VolleyError error){
                Log.d("tag", "onErrosResponse: "+ error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }


}