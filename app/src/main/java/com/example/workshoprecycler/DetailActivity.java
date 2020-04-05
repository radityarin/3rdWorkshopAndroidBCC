package com.example.workshoprecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.workshoprecycler.model.Tweet;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.workshoprecycler.MainActivity.TWEET_EXTRA;

public class DetailActivity extends AppCompatActivity {

    private Tweet tweet;
    private CircleImageView civ_photo;
    private TextView tv_username, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tweet = getIntent().getParcelableExtra(TWEET_EXTRA);

        civ_photo = findViewById(R.id.img_item_photo);
        tv_username = findViewById(R.id.tv_item_username);
        tv_content = findViewById(R.id.tv_item_content);

        if(tweet != null) {
            showTweet(tweet);
        }
    }

    private void showTweet(Tweet tweet) {
        Glide.with(this)
                .load(tweet.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(civ_photo);
        tv_username.setText(tweet.getUsername());
        tv_content.setText(tweet.getContent());
    }
}
