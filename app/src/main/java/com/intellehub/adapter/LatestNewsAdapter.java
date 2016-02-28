package com.intellehub.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.intellehub.application.FullArticleActivity;
import com.intellehub.extras.Constants;
import com.intellehub.extras.MyApplication;
import com.intellehub.network.VolleySingleton;
import com.intellehub.pojo.LatestNews;
import com.intellehub.sportshub.R;

import java.util.ArrayList;


public class LatestNewsAdapter extends RecyclerView.Adapter<LatestNewsAdapter.VhLatestNews> {

    private LayoutInflater liLatestNews;
    private ArrayList<LatestNews> latestNewslist = new ArrayList<>();
    private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;

    public LatestNewsAdapter(Context context) {
        liLatestNews = LayoutInflater.from(context);
        mVolleySingleton = VolleySingleton.getInstance();
        mImageLoader = mVolleySingleton.getImageLoader();
    }

    public void setLatestNews(ArrayList<LatestNews> listLatestlist) {
        this.latestNewslist = listLatestlist;
        //update the adapter to reflect the new set of movies
        notifyDataSetChanged();
        //L.t(MyApplication.getAppContext(), String.valueOf(listLatestlist.size()));
    }

    @Override
    public VhLatestNews onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = liLatestNews.inflate(R.layout.news_row, parent, false);
        VhLatestNews vhLatestNews = new VhLatestNews(view);
        return vhLatestNews;
    }

    @Override
    public void onBindViewHolder(VhLatestNews holder, int position) {
        LatestNews latestNews = latestNewslist.get(position);
        //one or more fields of the Movie object may be null since they are fetched from the web
        holder.tvTitle.setText(latestNews.get_title());
        holder.tvDescription.setText(latestNews.get_abstract());
        loadImages(latestNews.get_image(), holder);
        holder.setItem(latestNews);
    }

    private void loadImages(String urlThumbnail, final VhLatestNews holder) {
        if (!urlThumbnail.equals(Constants.NA)) {
            mImageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.ivImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return latestNewslist.size();
    }

    static class VhLatestNews extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle, tvDescription;
        ImageView ivImage;
        private LatestNews latestNews;

        public VhLatestNews(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivImage = (ImageView) itemView.findViewById(R.id.ivNewsImage);

            itemView.setOnClickListener(this);
        }

        public void setItem(LatestNews latestNews) {
            this.latestNews = latestNews;
        }

        @Override
        public void onClick(View v) {
            //L.t(MyApplication.getAppContext(), latestNews.get_abstract());

            Intent i = new Intent(MyApplication.getAppContext(), FullArticleActivity.class);
            i.putExtra("currentNews", latestNews);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            MyApplication.getAppContext().startActivity(i);
        }
    }

}
