package com.servicio.rapivid_19mx.ui.estados;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.Estado;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterEstados extends RecyclerView.Adapter<AdapterEstados.ViewHolder>{
    private ArrayList<Estado> lista;
    private Context contexto;
    int position;
    FragmentActivity fragmentActivity;

    public AdapterEstados(ArrayList estados, Context context, FragmentActivity fragmentActivity){
        this.lista = estados;
        this.contexto=context;
        this.fragmentActivity=fragmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jlist_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEstados.ViewHolder holder, final int position) {
        holder.setEstados(lista.get(position));
        final Estado edo = lista.get(position);
        holder.nombre.setText(edo.getNombre());
        holder.setSemaforoImg(edo.getSemaforo());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, EstadosVista.class);
                intent.putExtra("KEY_ESTADO", edo);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre;
        ImageView semaforoImg;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombre = itemView.findViewById(R.id.nombre_estado_list);
            this.semaforoImg = itemView.findViewById(R.id.color_semaforo_list);
            this.constraintLayout = itemView.findViewById(R.id.constraint_cv);
        }

        public void setEstados(Estado estados){
            nombre.setText(estados.getNombre());
        }

        public void setSemaforoImg(int semaforo){
            switch (semaforo){
                case 1:
                    semaforoImg.setImageResource(R.drawable.semaforo_rojo);
                    break;
                case 2:
                    semaforoImg.setImageResource(R.drawable.semaforo_naranja);
                    break;
                case 3:
                    semaforoImg.setImageResource(R.drawable.semaforo_amarillo);
                    break;
                case 4:
                    semaforoImg.setImageResource(R.drawable.semaforo_verde);
                    break;
            }
        }

    }
}