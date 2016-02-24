package com.intellehub.json;


import com.intellehub.extras.MyApplication;
import static com.intellehub.extras.UrlEndpoints.URL_NEWS_LATEST;
import static com.intellehub.extras.UrlEndpoints.URL_CHAR_AMEPERSAND;
import static com.intellehub.extras.UrlEndpoints.URL_CHAR_QUESTION;
import static com.intellehub.extras.UrlEndpoints.URL_PARAM_API_KEY;
import static com.intellehub.extras.UrlEndpoints.URL_PARAM_LIMIT;
import static com.intellehub.extras.UrlEndpoints.URL_NEWS_POPULAR;
/**
 * Created by Windows on 02-03-2015.
 */
public class Endpoints {
    public static String getRequestUrlBoxOfficeMovies(int limit) {

        return URL_NEWS_LATEST
                + URL_CHAR_QUESTION
                + URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + URL_CHAR_AMEPERSAND
                + URL_PARAM_LIMIT + limit;
    }

    public static String getRequestUrlUpcomingMovies(int limit) {

        return URL_NEWS_POPULAR
                + URL_CHAR_QUESTION
                + URL_PARAM_API_KEY + MyApplication.API_KEY_ROTTEN_TOMATOES
                + URL_CHAR_AMEPERSAND
                + URL_PARAM_LIMIT + limit;
    }
}
