package com.intellehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intellehub.adapter.LatestNewsAdapter;
import com.intellehub.callbacks.LatestNewsLoadedListener;
import com.intellehub.pojo.LatestNews;
import com.intellehub.sportshub.R;
import com.intellehub.task.TaskLoadLatestNews;

import java.util.ArrayList;

public class LatestNewsFragment extends Fragment implements LatestNewsLoadedListener{
    RecyclerView rvNews;
    ArrayList<LatestNews> latestNewsList = new ArrayList<LatestNews>();
    LatestNewsAdapter latestNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_latest_news_layout, null);
        rvNews = (RecyclerView) view.findViewById(R.id.rvNews);
        latestNewsAdapter = new LatestNewsAdapter(getActivity());
        //latestNewsAdapter.setLatestNews(latestNewsList);

        rvNews.setAdapter(latestNewsAdapter);
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));

        new TaskLoadLatestNews(this).execute();

        return view;
    }

    @Override
    public void onLatestNewsLoaded(ArrayList<LatestNews> listLatestNews) {
        latestNewsAdapter.setLatestNews(listLatestNews);
    }
}
