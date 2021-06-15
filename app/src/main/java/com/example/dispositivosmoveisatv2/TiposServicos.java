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


public class TiposServicos extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Servicos> servicos;
    String JSON_URL = "https://my-json-server.typicode.com/paulolucas/atividade2DispositivosMoveis/Servicos";
    AdapterServicos adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_servicos);
        recyclerView = findViewById(R.id.servicos_lista);
        setTitle("Serviços");
        servicos = new ArrayList<>();

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
                        Servicos servicos1 = new Servicos();
                        servicos1.setTipo(Object.getString("tipo").toString());
                        servicos.add(servicos1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterServicos(getApplicationContext(), servicos);
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