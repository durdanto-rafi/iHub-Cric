package com.intellehub.extras;

import com.android.volley.RequestQueue;
import com.intellehub.json.Endpoints;
import com.intellehub.json.Parser;
import com.intellehub.json.Requestor;
import com.intellehub.pojo.LatestNews;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Windows on 02-03-2015.
 */
public class LatestNewsUtils {
    public static ArrayList<LatestNews> loadLatestNews(RequestQueue requestQueue) {
        JSONObject response = Requestor.requestMoviesJSON(requestQueue, Endpoints.getRequestUrlLatestNews(30));
        ArrayList<LatestNews> latestNewsList = Parser.parseLatestNewsJson(response);
        //MyApplication.getWritableDatabase().insertMovies(DBMovies.BOX_OFFICE, listMovies, true);
        return latestNewsList;
    }

}
