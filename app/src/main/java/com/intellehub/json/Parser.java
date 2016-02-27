package com.intellehub.json;

import com.intellehub.extras.Constants;
import com.intellehub.pojo.LatestNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.intellehub.extras.Keys.EndpointNews.KEY_ABSTRACT;
import static com.intellehub.extras.Keys.EndpointNews.KEY_AUTHOR;
import static com.intellehub.extras.Keys.EndpointNews.KEY_CATEGORY;
import static com.intellehub.extras.Keys.EndpointNews.KEY_DATA;
import static com.intellehub.extras.Keys.EndpointNews.KEY_ID;
import static com.intellehub.extras.Keys.EndpointNews.KEY_IMAGE;
import static com.intellehub.extras.Keys.EndpointNews.KEY_TITLE;


/**
 * Created by Windows on 02-03-2015.
 */
public class Parser
{
    public static ArrayList<LatestNews> parseLatestNewsJson(JSONObject response)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<LatestNews> latestNewsList = new ArrayList<>();
        if (response != null && response.length() > 0)
        {
            try
            {
                JSONArray arrayLatestNews = response.getJSONArray(KEY_DATA);
                for (int i = 0; i < arrayLatestNews.length(); i++)
                {
                    int id = -1;
                    String title = Constants.NA;
                    String image = Constants.NA;
                    String abstracts = Constants.NA;
                    String author = Constants.NA;
                    String category = Constants.NA;

                    JSONObject currentLatestNews = arrayLatestNews.getJSONObject(i);
                    //get the id of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_ID))
                    {
                        id = currentLatestNews.getInt(KEY_ID);
                    }
                    //get the title of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_TITLE)) {
                        title = currentLatestNews.getString(KEY_TITLE);
                    }
                    //get the image of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_IMAGE)) {
                        image = currentLatestNews.getString(KEY_IMAGE);
                    }
                    //get the abstract of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_ABSTRACT)) {
                        abstracts = currentLatestNews.getString(KEY_ABSTRACT);
                    }
                    //get the author of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_AUTHOR)) {
                        author = currentLatestNews.getString(KEY_AUTHOR);
                    }
                    //get the category of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_CATEGORY)) {
                        category = currentLatestNews.getString(KEY_CATEGORY);
                    }

                    LatestNews latestNews = new LatestNews();
                    latestNews.set_id(id);
                    latestNews.set_title(title);
                    latestNews.set_image(image);
                    latestNews.set_abstract(abstracts);
                    latestNews.set_author(author);
                    latestNews.set_category(category);

//                    L.t(getActivity(), movie + "");
                    if (id != -1 && !title.equals(Constants.NA)) {
                        latestNewsList.add(latestNews);
                    }
                }

            } catch (JSONException e) {

            }
//                L.t(getActivity(), listMovies.size() + " rows fetched");
        }
        return latestNewsList;
    }


}
