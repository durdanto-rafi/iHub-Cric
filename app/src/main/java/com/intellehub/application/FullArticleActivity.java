package com.intellehub.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.intellehub.extras.Constants;
import com.intellehub.network.VolleySingleton;
import com.intellehub.pojo.LatestNews;
import com.intellehub.sportshub.R;

public class FullArticleActivity extends AppCompatActivity {

    LatestNews latestNews;
    TextView tvArticle;
    ImageView ivArticImageView;
    private VolleySingleton mVolleySingleton;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);
        mVolleySingleton = VolleySingleton.getInstance();
        mImageLoader = mVolleySingleton.getImageLoader();
        tvArticle = (TextView)findViewById(R.id.tvArticle);
        ivArticImageView = (ImageView) findViewById(R.id.ivArticleImage);


        Intent i = getIntent();
        latestNews = i.getParcelableExtra("currentNews");
        //L.t(MyApplication.getAppContext(), latestNews.get_image());
        tvArticle.setText(latestNews.get_abstract());
        loadImages(latestNews.get_image(),ivArticImageView);
    }

    private void loadImages(String urlThumbnail, final ImageView iv) {
        if (!urlThumbnail.equals(Constants.NA)) {
            mImageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    iv.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }
}
