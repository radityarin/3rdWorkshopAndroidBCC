package com.example.workshoprecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.workshoprecycler.model.Tweet;

import static com.example.workshoprecycler.MainActivity.TWEET_EXTRA;

public class DetailActivity extends AppCompatActivity {

    private Tweet tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tweet = getIntent().getParcelableExtra(TWEET_EXTRA);

        Toast.makeText(this, tweet.getContent(), Toast.LENGTH_SHORT).show();
    }
}
