package com.servicio.rapivid_19mx.ui.estados;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.Estado;

public class EstadosVista extends AppCompatActivity {
    private String nombre, activos, mortales, recuperados, totales;
    private int semaforo;
    private TextView nombreTextv, n_activos_edo, n_muertes_edo, n_recuperados_edo, n_totales_edo,
    color_semaforo, info_completa, info_corta;
    private ImageView semaforoImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados_vista);
        initComponents();
        readState();

        nombreTextv.setText(nombre);
        n_activos_edo.setText(activos);
        n_muertes_edo.setText(mortales);
        n_recuperados_edo.setText(recuperados);
        n_totales_edo.setText(totales);

        switch (semaforo){
            case 1:
                color_semaforo.setText(R.string.red);
                semaforoImg.setImageResource(R.drawable.semaforo_rojo);
                info_corta.setText(R.string.rojo_s);
                info_completa.setText(R.string.rojo);
                break;
            case 2:
                color_semaforo.setText(R.string.orange);
                semaforoImg.setImageResource(R.drawable.semaforo_naranja);
                info_corta.setText(R.string.naranja_s);
                info_completa.setText(R.string.naranja);
                break;
            case 3:
                color_semaforo.setText(R.string.yellow);
                semaforoImg.setImageResource(R.drawable.semaforo_amarillo);
                info_corta.setText(R.string.amarillo_s);
                info_completa.setText(R.string.amarillo);
                break;
            case 4:
                color_semaforo.setText(R.string.green);
                semaforoImg.setImageResource(R.drawable.semaforo_verde);
                info_corta.setText(R.string.verde_s);
                info_completa.setText(R.string.verde);
                break;
        }
    }

    public void initComponents(){
        nombreTextv=findViewById(R.id.estado_nombre);
        n_activos_edo=findViewById(R.id.n_activos_edo);
        n_muertes_edo=findViewById(R.id.n_muertes_edo);
        n_recuperados_edo=findViewById(R.id.n_recuperados_edo);
        n_totales_edo=findViewById(R.id.n_totales_edo);
        semaforoImg=findViewById(R.id.img_color_semaforo);
        color_semaforo=findViewById(R.id.color_semaforo);
        info_completa=findViewById(R.id.info_completa);
        info_corta=findViewById(R.id.info_rapida);
    }

    public void readState(){
        Estado estado=(Estado) getIntent().getSerializableExtra("KEY_ESTADO");

        nombre=estado.getNombre();
        activos=estado.getActivos();
        mortales=estado.getMortales();
        recuperados=estado.getRecuperados();
        totales=estado.getTotales();
        semaforo=estado.getSemaforo();
    }

}