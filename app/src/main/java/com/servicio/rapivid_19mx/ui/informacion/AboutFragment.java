package com.servicio.rapivid_19mx.ui.informacion;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.servicio.rapivid_19mx.R;

public class AboutFragment extends Fragment {

    private LinearLayout expandibleView, expandibleView2;
    private Button arrowButton, arrowButton2;
    private CardView cardView, cardView2;

    public AboutFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_about, container, false);
        root=initComponents(root);

        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandibleView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    TransitionManager.beginDelayedTransition(cardView2);
                    expandibleView.setVisibility(View.VISIBLE);
                    arrowButton.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    expandibleView.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    TransitionManager.beginDelayedTransition(cardView2);
                    arrowButton.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });

        arrowButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandibleView2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandibleView2.setVisibility(View.VISIBLE);
                    arrowButton2.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    TransitionManager.beginDelayedTransition(cardView2, new AutoTransition());
                    expandibleView2.setVisibility(View.GONE);
                    arrowButton2.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });
        return root;
    }

    public View initComponents(View root){
        expandibleView=root.findViewById(R.id.texto_sikntoas);
        arrowButton=root.findViewById(R.id.button_verweas);
        cardView=root.findViewById(R.id.sintomas_cv);

        expandibleView2=root.findViewById(R.id.texto_tratamiento);
        arrowButton2=root.findViewById(R.id.button_verweas2);
        cardView2=root.findViewById(R.id.tratamiendo_cv);
        return root;
    }
}