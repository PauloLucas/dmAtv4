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

public class AdapterServicos extends RecyclerView.Adapter<AdapterServicos.ViewHolder>{

    LayoutInflater inflater;
    List<Servicos> servicos;
        public AdapterServicos(Context ctx, List<Servicos> servicos){
        this.inflater = LayoutInflater.from((ctx));
        this.servicos= servicos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_servicos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tipo.setText(servicos.get(position).getTipo());

    }

    @Override
    public int getItemCount() {
        return servicos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tipo = itemView.findViewById(R.id.textTipoServ);

        }
    }
}

