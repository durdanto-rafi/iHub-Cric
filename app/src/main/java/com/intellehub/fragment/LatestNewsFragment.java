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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.primary_layout, null);
        rvNews = (RecyclerView) view.findViewById(R.id.rvNews);

        new TaskLoadLatestNews(this).execute();

        LatestNewsAdapter adapter = new LatestNewsAdapter(getActivity());
        rvNews.setAdapter(adapter);
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onLatestNewsLoaded(ArrayList<LatestNews> listLatestNews) {

    }
}
