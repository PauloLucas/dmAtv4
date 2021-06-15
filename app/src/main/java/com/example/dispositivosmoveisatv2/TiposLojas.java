package com.example.dispositivosmoveisatv2;


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


public class TiposLojas extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Lojas> lojas;
    String JSON_URL = "https://my-json-server.typicode.com/paulolucas/atividade2DispositivosMoveis/Lojas";
    AdapterLojas adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_lojas);
        recyclerView = findViewById(R.id.lojas_list);
        setTitle("Lojas");
        lojas = new ArrayList<>();

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
                        Lojas   lojas1 = new Lojas();
                        lojas1.setLocalidade(Object.getString("Localidade").toString());
                        lojas1.setEndereco(Object.getString("Endereço").toString());
                        lojas1.setNumero(Object.getString("Numero").toString());
                        lojas1.setTelefone(Object.getString("Telefone").toString());
                        lojas1.setEmail(Object.getString("Email").toString());

                        lojas.add(lojas1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterLojas(getApplicationContext(), lojas);
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