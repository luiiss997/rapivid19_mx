package com.servicio.rapivid_19mx.ui.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.modelo.rss.RSSObject;
import com.squareup.picasso.Picasso;


public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {
    private RSSObject RSSObj;
    private Context context;

    public AdapterNews(RSSObject RSSObj, Context context) {
        this.RSSObj = RSSObj;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticia_item,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.ViewHolder holder, final int position) {
        holder.setImage(RSSObj.getItems().get(position).getEnclosure().link);
        holder.title_new.setText(RSSObj.getItems().get(position).getTitle());
        holder.date_new.setText(RSSObj.getItems().get(position).getPubDate());
        holder.description_new.setText(RSSObj.getItems().get(position).getDescription());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent navegador=new Intent(Intent.ACTION_VIEW,
                        Uri.parse(RSSObj.getItems().get(position).getLink()));
                navegador.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(navegador);
            }
        });
    }

    @Override
    public int getItemCount() {
        return RSSObj.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView date_new, description_new, title_new;
        public LinearLayout constraintLayout;
        public ImageView image_new;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.constraintLayout=itemView.findViewById(R.id.noticia_layout);
            this.title_new=itemView.findViewById(R.id.title_new);
            this.description_new=itemView.findViewById(R.id.description_new);
            this.date_new=itemView.findViewById(R.id.date_new);
            this.image_new=itemView.findViewById(R.id.image_new);
        }

        public void setImage(String url){
            Picasso.get().load(url).into(image_new);
        }
    }
}
