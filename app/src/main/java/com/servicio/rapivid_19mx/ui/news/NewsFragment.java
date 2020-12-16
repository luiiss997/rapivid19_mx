package com.servicio.rapivid_19mx.ui.news;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.servicio.rapivid_19mx.R;
import com.servicio.rapivid_19mx.common.HTTPDataHandler;
import com.servicio.rapivid_19mx.modelo.rss.RSSObject;

/**
 * Luis
 */

public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RSSObject RSSObj;
    private AdapterNews adapterNews;
    private final String rss_link="https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fexpansion.mx%2Frss";

    public NewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_news, container, false);
        recyclerView=root.findViewById(R.id.noticias);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        loadRSS();
        return root;
    }

    private void loadRSS(){
         AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(getContext());

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Cargando...");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return  result;
            }

            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                RSSObj = new Gson().fromJson(s, RSSObject.class);
                adapterNews = new AdapterNews(RSSObj,getActivity().getBaseContext());
                if (RSSObj==null){
                    Log.d("UNU", "Sin Conexion a Internet");
                }else{
                    recyclerView.setAdapter(adapterNews);
                    adapterNews.notifyDataSetChanged();
                    Log.d("UNU", "aasdsdasdasdaG");
                }
            }
        };

        loadRSSAsync.execute(rss_link);

    }
}