package com.intellehub.callbacks;

import com.intellehub.pojo.LatestNews;

import java.util.ArrayList;


/**
 * Created by Windows on 02-03-2015.
 */
public interface LatestNewsLoadedListener {
    public void onLatestNewsLoaded(ArrayList<LatestNews> listLatestNews);
}
