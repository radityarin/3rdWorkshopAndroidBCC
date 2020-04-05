package com.example.workshoprecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.workshoprecycler.adapter.TweetAdapter;
import com.example.workshoprecycler.model.Tweet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TweetAdapter.OnTweetClickCallback {

    private RecyclerView rv_tweets;
    public static final String TWEET_EXTRA = "tweet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_tweets = findViewById(R.id.rv_tweets);

        showTweets();
    }

    private void showTweets() {
        rv_tweets.setLayoutManager(new LinearLayoutManager(this));
        TweetAdapter tweetAdapter = new TweetAdapter(getDummyTweets());
        rv_tweets.setAdapter(tweetAdapter);
        tweetAdapter.setOnTweetClickCallback(this);
    }

    private ArrayList<Tweet> getDummyTweets(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataContent = getResources().getStringArray(R.array.data_content);
        String[] dataPhoto = getResources().getStringArray(R.array.data_photo);

        ArrayList<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Tweet tweet = new Tweet();
            tweet.setUsername(dataName[i]);
            tweet.setContent(dataContent[i]);
            tweet.setPhoto(dataPhoto[i]);

            tweets.add(tweet);
        }
        return tweets;
    }

    @Override
    public void onTweetClicked(Tweet tweet) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(TWEET_EXTRA,tweet);
        startActivity(intent);
    }
}
