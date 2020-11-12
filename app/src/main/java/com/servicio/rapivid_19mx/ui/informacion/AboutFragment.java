package com.servicio.rapivid_19mx.ui.informacion;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.servicio.rapivid_19mx.R;

public class AboutFragment extends Fragment {

    private LinearLayout expandibleView, expandibleView2, expandibleView3, expandibleView4;
    private Button arrowButton, arrowButton2, arrowButton3, arrowButton4;
    private ScrollView scrollView;

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
                    TransitionManager.beginDelayedTransition(scrollView);
                    expandibleView.setVisibility(View.VISIBLE);
                    arrowButton.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    expandibleView.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(scrollView);
                    arrowButton.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });

        arrowButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandibleView2.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(scrollView);
                    expandibleView2.setVisibility(View.VISIBLE);
                    arrowButton2.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    expandibleView2.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(scrollView);
                    arrowButton2.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });

        arrowButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandibleView3.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(scrollView);
                    expandibleView3.setVisibility(View.VISIBLE);
                    arrowButton3.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    expandibleView3.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(scrollView);
                    arrowButton3.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });

        arrowButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expandibleView4.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(scrollView);
                    expandibleView4.setVisibility(View.VISIBLE);
                    arrowButton4.setBackgroundResource(R.drawable.ic_arrow_up);
                }else{
                    expandibleView4.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(scrollView);
                    arrowButton4.setBackgroundResource(R.drawable.ic_arrow_down_24);
                }
            }
        });

        return root;
    }

    public View initComponents(View root){
        scrollView=root.findViewById(R.id.scroll_view);

        expandibleView=root.findViewById(R.id.texto_sikntoas);
        arrowButton=root.findViewById(R.id.button_verweas);

        expandibleView2=root.findViewById(R.id.texto_tratamiento);
        arrowButton2=root.findViewById(R.id.button_verweas2);

        expandibleView3=root.findViewById(R.id.texto_preguntas);
        arrowButton3=root.findViewById(R.id.button_verweas3);

        expandibleView4=root.findViewById(R.id.texto_cuidados);
        arrowButton4=root.findViewById(R.id.button_verweas4);
        return root;
    }
}