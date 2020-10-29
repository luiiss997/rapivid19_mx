package com.servicio.rapivid_19mx.ui.estados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import com.servicio.rapivid_19mx.R;

public class EstadosVista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados_vista);
        Toolbar toolbar = findViewById(R.id.toolbar_edo);
        setSupportActionBar(toolbar);
    }
}