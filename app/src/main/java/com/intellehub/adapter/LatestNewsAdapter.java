package com.intellehub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.intellehub.pojo.LatestNews;
import com.intellehub.sportshub.R;

import java.util.ArrayList;


public class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.VhLatestNews> {

    private LayoutInflater liLatestNews;
    private ArrayList<LatestNews> latestNewsList = new ArrayList<LatestNews>();

    public LatestNewsAdapter(Context context) {
        liLatestNews = LayoutInflater.from(context);
    }

    @Override
    public VhLatestNews onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = liLatestNews.inflate(R.layout.news_row, parent, false);
        VhLatestNews vhLatestNews = new VhLatestNews(view);
        return vhLatestNews;
    }

    @Override
    public void onBindViewHolder(VhLatestNews holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class VhLatestNews extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDescription;
        ImageView ivImage;

        public VhLatestNews(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivImage = (ImageView) itemView.findViewById(R.id.ivNewsImage);
        }
    }

}
