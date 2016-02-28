package com.intellehub.json;

import com.intellehub.extras.Constants;
import com.intellehub.pojo.LatestNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.intellehub.extras.Keys.EndpointNews.KEY_ABSTRACT;
import static com.intellehub.extras.Keys.EndpointNews.KEY_AUTHOR;
import static com.intellehub.extras.Keys.EndpointNews.KEY_CATEGORY;
import static com.intellehub.extras.Keys.EndpointNews.KEY_DATA;
import static com.intellehub.extras.Keys.EndpointNews.KEY_ID;
import static com.intellehub.extras.Keys.EndpointNews.KEY_IMAGE;
import static com.intellehub.extras.Keys.EndpointNews.KEY_TITLE;
import static com.intellehub.extras.Keys.EndpointNews.KEY_FULL_IMAGE;
import static com.intellehub.extras.Keys.EndpointNews.KEY_FULL_STORY;

/**
 * Created by Windows on 02-03-2015.
 */
public class Parser {
    public static ArrayList<LatestNews> parseLatestNewsJson(JSONObject response) {
        ArrayList<LatestNews> latestNewsList = new ArrayList<>();
        if (response != null && response.length() > 0) {
            try {
                JSONArray arrayLatestNews = response.getJSONArray(KEY_DATA);
                for (int i = 0; i < arrayLatestNews.length(); i++) {
                    int id = -1;
                    String title = Constants.NA;
                    String image = Constants.NA;
                    String abstracts = Constants.NA;
                    String author = Constants.NA;
                    String category = Constants.NA;
                    String fullImage = Constants.NA;
                    String fullStory = Constants.NA;

                    JSONObject currentLatestNews = arrayLatestNews.getJSONObject(i);
                    //get the id of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_ID)) {
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
                    //get the category of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_FULL_IMAGE)) {
                        fullImage = currentLatestNews.getString(KEY_FULL_IMAGE);
                    }
                    //get the category of the current latest news
                    if (Utils.contains(currentLatestNews, KEY_FULL_STORY)) {
                        fullStory = currentLatestNews.getString(KEY_FULL_STORY);
                    }

                    LatestNews latestNews = new LatestNews();
                    latestNews.set_id(id);
                    latestNews.set_title(title);
                    latestNews.set_image(image);
                    latestNews.set_abstract(abstracts);
                    latestNews.set_author(author);
                    latestNews.set_category(category);
                    latestNews.set_full_image(fullImage);
                    latestNews.set_full_story(fullStory);

                    if (id != -1 && !title.equals(Constants.NA)) {
                        latestNewsList.add(latestNews);
                    }
                }

            } catch (JSONException e) {

            }
        }
        return latestNewsList;
    }


}
