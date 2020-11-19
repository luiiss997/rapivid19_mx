package com.servicio.rapivid_19mx.ui.estados;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.Estado;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */

public class listaEstadosFragment extends Fragment {
    final ArrayList<Estado> arrayListEstados = new ArrayList<Estado>();
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

        databaseReference.child("estados").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Estado estado = ds.getValue(Estado.class);
                    arrayListEstados.add(estado);
                }

                Estado puebla = new Estado("asdas", "asda", "asdas", "asdas", "asdas", 1);
                Estado puebla2 = new Estado("peuieu", "asda", "asdas", "asdas", "asdas", 2);
                arrayListEstados.add(puebla);
                arrayListEstados.add(puebla2);

                adapterEstados.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
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