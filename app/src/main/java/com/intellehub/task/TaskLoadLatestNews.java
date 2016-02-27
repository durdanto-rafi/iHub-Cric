package com.intellehub.task;

import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.intellehub.callbacks.LatestNewsLoadedListener;
import com.intellehub.extras.LatestNewsUtils;
import com.intellehub.network.VolleySingleton;
import com.intellehub.pojo.LatestNews;

import java.util.ArrayList;

/**
 * Created by Windows on 02-03-2015.
 */
public class TaskLoadLatestNews extends AsyncTask<Void, Void, ArrayList<LatestNews>> {
    private LatestNewsLoadedListener myComponent;
    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;



    public TaskLoadLatestNews(LatestNewsLoadedListener myComponent) {

        this.myComponent = myComponent;
        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();
    }


    @Override
    protected ArrayList<LatestNews> doInBackground(Void... params) {

        ArrayList<LatestNews> listLatestNews = LatestNewsUtils.loadLatestNews(requestQueue);
        return listLatestNews;
    }

    @Override
    protected void onPostExecute(ArrayList<LatestNews> listLatestNews) {
        if (myComponent != null) {
            myComponent.onLatestNewsLoaded(listLatestNews);
        }
    }


}
