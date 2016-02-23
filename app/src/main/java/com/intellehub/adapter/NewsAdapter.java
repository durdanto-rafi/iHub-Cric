package com.intellehub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intellehub.sportshub.R;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.vhNews> {

    private LayoutInflater liNews;
    public NewsAdapter(Context context)
    {
        liNews = LayoutInflater.from(context);
    }

    @Override
    public vhNews onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = liNews.inflate(R.layout.news_row, parent, false);
        
        return null;
    }

    @Override
    public void onBindViewHolder(vhNews holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class vhNews extends RecyclerView.ViewHolder{

        public vhNews(View itemView) {
            super(itemView);
        }
    }

}
