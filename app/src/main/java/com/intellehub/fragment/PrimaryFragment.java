package com.intellehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intellehub.adapter.NewsAdapter;
import com.intellehub.sportshub.R;

public class PrimaryFragment extends Fragment {
    RecyclerView rvNews;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.primary_layout, null);

        rvNews = (RecyclerView) view.findViewById(R.id.rvNews);

        NewsAdapter adapter = new NewsAdapter(getActivity());
        rvNews.setAdapter(adapter);
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
