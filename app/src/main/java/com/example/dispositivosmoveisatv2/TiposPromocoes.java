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


public class TiposPromocoes extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Promocoes> promocoes;
    String JSON_URL = "https://my-json-server.typicode.com/paulolucas/atividade2DispositivosMoveis/Promocoes";
    AdapterPromocoes adapter;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_promocoes);
        recyclerView = findViewById(R.id.promocoes_lista);
        setTitle("Promoções");
        promocoes = new ArrayList<>();

        extrairPromo();
    }

    private void extrairPromo() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject Object = response.getJSONObject(i);
                        Promocoes promocoes1 = new Promocoes();
                        promocoes1.setTipo(Object.getString("tipo").toString());
                        promocoes1.setTamanho(Object.getString("Tamanho").toString());
                        promocoes1.setValor(Object.getString("valor").toString());
                        promocoes.add(promocoes1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterPromocoes(getApplicationContext(), promocoes);
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