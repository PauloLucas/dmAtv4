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

public class AdapterPromocoes extends RecyclerView.Adapter<AdapterPromocoes.ViewHolder>{

    LayoutInflater inflater;
    List<Promocoes> promocoes;
    public AdapterPromocoes(Context ctx, List<Promocoes> promocoes){
        this.inflater = LayoutInflater.from((ctx));
        this.promocoes= promocoes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_promocoes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tipo.setText(promocoes.get(position).getTipo());
        holder.Tamanho.setText(promocoes.get(position).getTamanho());
        holder.valor.setText(promocoes.get(position).getValor());

    }

    @Override
    public int getItemCount() {
        return promocoes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tipo, Tamanho, valor;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tipo = itemView.findViewById(R.id.textTipoPromo);
            Tamanho = itemView.findViewById(R.id.textTamanhoPromo);
            valor = itemView.findViewById(R.id.textValorPromo);

        }
    }
}
