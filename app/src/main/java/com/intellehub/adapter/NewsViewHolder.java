package com.intellehub.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.intellehub.sportshub.R;

/**
 * Created by kundan on 10/26/2015.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle, tvDescription;
    ImageView ivNewsImage;


    public NewsViewHolder(View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
        ivNewsImage = (ImageView) itemView.findViewById(R.id.ivNewsImage);

    }
}
