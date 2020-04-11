package com.example.workshoprecycler.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.workshoprecycler.DetailActivity;
import com.example.workshoprecycler.R;
import com.example.workshoprecycler.adapter.TweetAdapter;
import com.example.workshoprecycler.model.Tweet;

import java.util.ArrayList;

public class TweetFragment extends Fragment implements TweetAdapter.OnTweetClickCallback {

    private RecyclerView rv_tweets;
    public static final String TWEET_EXTRA = "tweet";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tweet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_tweets = view.findViewById(R.id.rv_tweets);

        showTweets();
    }

    private void showTweets() {
        rv_tweets.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(TWEET_EXTRA,tweet);
        startActivity(intent);
    }
}
