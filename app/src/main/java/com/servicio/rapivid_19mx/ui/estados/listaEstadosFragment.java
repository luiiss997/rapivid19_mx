package com.servicio.rapivid_19mx.ui.estados;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.Estado;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */

public class listaEstadosFragment extends Fragment {
    private ArrayList<Estado> arrayListEstados = new ArrayList<Estado>();
    private RecyclerView recyclerView;
    private AdapterEstados adapterEstados;
    private DatabaseReference databaseReference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lista_estados, container, false);
        root = initComponents(root);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        final View c=root;
        databaseReference.child("estados").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Estado estado = ds.getValue(Estado.class);
                    arrayListEstados.add(estado);
                }
                adapterEstados.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Snackbar.make(c, "Esto es una prueba", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        adapterEstados = new AdapterEstados(arrayListEstados, getContext(), getActivity());
        recyclerView.setAdapter(adapterEstados);
        return root;
    }

    public View initComponents(View view) {
        recyclerView = view.findViewById(R.id.jlist1);
        return view;
    }

}