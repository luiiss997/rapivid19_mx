package com.servicio.rapivid_19mx.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.Mexico;

public class HomeFragment extends Fragment {
    private TextView activos, mortales, recuperados, totales, u_act, fuente, txtf, txtf2;
    private Button button1, button2;
    private ImageView imageView1, imageView2;
    private DatabaseReference databaseReference;
    private Mexico mexico;
    private StorageReference storageReference;
    private FirebaseStorage storage;
    private Bitmap bitmapImg, bitmapImg2, bitmapImg3, bitmapImg4;
    private boolean bnd=true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        root=initComponents(root);

        storage = FirebaseStorage.getInstance();
        storageReference= storage.getReference();

        this.downloadImageData();

        mexico=new Mexico();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("mexico").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mexico=dataSnapshot.getValue(Mexico.class);
                mexico.setUlt_alt((String) dataSnapshot.child("ult_act").getValue());
                setData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        fuente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent web=new Intent();
                web.setAction(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.bing.com/covid?cc=es"));
                startActivity(web);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button1.setBackgroundResource(R.drawable.static_button);
                button2.setBackgroundResource(R.drawable.spinner_bg);
                imageView1.setImageBitmap(bitmapImg);
                imageView2.setImageBitmap(bitmapImg4);
                bnd=false;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setBackgroundResource(R.drawable.static_button);
                button1.setBackgroundResource(R.drawable.spinner_bg);
                imageView1.setImageBitmap(bitmapImg2);
                imageView2.setImageBitmap(bitmapImg3);
                bnd=true;
            }
        });

        final Context context=this.getContext();
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView = mView.findViewById(R.id.photoView);
                if (bnd){
                    photoView.setImageBitmap(bitmapImg2);
                }else{
                    photoView.setImageBitmap(bitmapImg);
                }
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView = mView.findViewById(R.id.photoView);
                if (bnd){
                    photoView.setImageBitmap(bitmapImg3);
                }else{
                    photoView.setImageBitmap(bitmapImg4);
                }
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        return root;
    }

    public View initComponents(View root) {
        activos = root.findViewById(R.id.n_activos_home);
        mortales = root.findViewById(R.id.n_muertes_home);
        recuperados = root.findViewById(R.id.n_recuperados_home);
        totales = root.findViewById(R.id.n_totales_home);
        u_act = root.findViewById(R.id.last_update);
        button1 = root.findViewById(R.id.button);
        button2 = root.findViewById(R.id.button2);
        imageView1=root.findViewById(R.id.imageView7);
        imageView2=root.findViewById(R.id.imageView6);
        fuente=root.findViewById(R.id.fuente);
        txtf=root.findViewById(R.id.failure_text);
        txtf2=root.findViewById(R.id.failure_text2);
        return root;
    }

    public void setData(){
        activos.setText(mexico.getActivos());
        mortales.setText(mexico.getMortales());
        recuperados.setText(mexico.getRecuperados());
        totales.setText(mexico.getTotales());
        u_act.setText(mexico.getUlt_alt());
    }

    public void downloadImageData(){
        StorageReference image1 = storageReference.child("images/grafico_activos.png");
        long MAXBYTES =  1500*580;
        image1.getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                bitmapImg = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                imageView1.setVisibility(View.INVISIBLE);
                imageView1.setEnabled(false);
                txtf.setVisibility(View.VISIBLE);
            }
        });

         image1 = storageReference.child("images/grafico_tendencias.png");
         MAXBYTES =  1500*660;
        image1.getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                bitmapImg2 = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
                imageView1.setImageBitmap(bitmapImg2);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                imageView1.setVisibility(View.INVISIBLE);
                txtf.setVisibility(View.VISIBLE);
                imageView1.setEnabled(false);
            }
        });

        image1 = storageReference.child("images/COV19_Dashboard.png");
        MAXBYTES =  2156*1436;
        image1.getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                bitmapImg3 = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                imageView2.setVisibility(View.INVISIBLE);
                txtf2.setVisibility(View.VISIBLE);
                imageView2.setEnabled(false);
            }
        });

        image1 = storageReference.child("images/COV19_Mapa.png");
        MAXBYTES =  2156*1436;
        image1.getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                bitmapImg4 = BitmapFactory.decodeByteArray(bytes,0, bytes.length);
                imageView2.setImageBitmap(bitmapImg3);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                imageView2.setVisibility(View.INVISIBLE);
                txtf2.setVisibility(View.VISIBLE);
                imageView2.setEnabled(false);
            }
        });

    }
}