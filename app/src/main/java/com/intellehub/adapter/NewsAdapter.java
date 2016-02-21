package com.intellehub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.intellehub.sportshub.R;

/**
 * Created by kundan on 10/26/2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>
{

    String[] name = {"Androidwarriors", "Stackoverflow", "Developer Android", "AndroidHive",
            "Slidenerd", "TheNewBoston", "Truiton", "HmkCode", "JavaTpoint", "Javapeper"};
    Context context;
    LayoutInflater inflater;

    public NewsAdapter(Context context)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = inflater.inflate(R.layout.item_list, parent, false);
        NewsViewHolder viewHolder = new NewsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position)
    {
        holder.tvTitle.setText(name[position]);
        holder.ivNewsImage.setOnClickListener(clickListener);
        holder.ivNewsImage.setTag(holder);
    }

    View.OnClickListener clickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            NewsViewHolder vholder = (NewsViewHolder) v.getTag();
            int position = vholder.getPosition();
            Toast.makeText(context, "This is position " + position, Toast.LENGTH_LONG).show();
        }
    };


    @Override
    public int getItemCount()
    {
        return name.length;
    }
}
