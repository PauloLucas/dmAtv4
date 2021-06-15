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

public class AdapterLojas extends RecyclerView.Adapter<AdapterLojas.ViewHolder>{

    LayoutInflater inflater;
    List<Lojas> lojas;
    public AdapterLojas(Context ctx, List<Lojas> lojas){
        this.inflater = LayoutInflater.from((ctx));
        this.lojas= lojas;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_lojas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.localidade.setText(lojas.get(position).getLocalidade());
        holder.endereco.setText(lojas.get(position).getEndereco());
        holder.numero.setText("Numero: "+lojas.get(position).getNumero());
        holder.telefone.setText("Telefone: : "+lojas.get(position).getTelefone());
        holder.email.setText("E-mail: : "+lojas.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return lojas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView localidade,endereco,numero,telefone,email;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            localidade = itemView.findViewById(R.id.textUnidade);
            endereco = itemView.findViewById(R.id.textEnd);
            numero = itemView.findViewById(R.id.textNum);
            telefone = itemView.findViewById(R.id.textTel);
            email = itemView.findViewById(R.id.textEmail);


        }
    }
}

