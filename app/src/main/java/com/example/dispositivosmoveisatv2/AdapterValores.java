package com.example.dispositivosmoveisatv2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dispositivosmoveisatv1.R;

import java.util.List;

public class AdapterValores extends RecyclerView.Adapter<AdapterValores.ViewHolder>{

    LayoutInflater inflater;
    List<Valores> valores;
    public AdapterValores(Context ctx, List<Valores> valores){
        this.inflater = LayoutInflater.from((ctx));
        this.valores= valores;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_valores,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tipo.setText(valores.get(position).getTipo());
        holder.medida.setText(valores.get(position).getMedida());
        holder.valor.setText(valores.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return valores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo,medida,valor;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tipo = itemView.findViewById(R.id.textTipoValores);
            medida = itemView.findViewById(R.id.textMedidaValores);
            valor = itemView.findViewById(R.id.textValorValores);

        }
    }
}

