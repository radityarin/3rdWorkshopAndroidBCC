package com.example.workshoprecycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.workshoprecycler.R;
import com.example.workshoprecycler.model.Tweet;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private ArrayList<Tweet> list_tweets;
    private OnTweetClickCallback onTweetClickCallback;

    public TweetAdapter(ArrayList<Tweet> list_tweets) {
        this.list_tweets = list_tweets;
    }

    public void setOnTweetClickCallback(OnTweetClickCallback onTweetClickCallback) {
        this.onTweetClickCallback = onTweetClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Tweet tweet = list_tweets.get(position);
        holder.bind(tweet);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTweetClickCallback.onTweetClicked(tweet);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_tweets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView civ_item_photo;
        private TextView tv_username, tv_content;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            civ_item_photo = itemView.findViewById(R.id.img_item_photo);
            tv_username = itemView.findViewById(R.id.tv_item_username);
            tv_content = itemView.findViewById(R.id.tv_item_content);
        }

        void bind(Tweet tweet) {
            Glide.with(itemView.getContext())
                    .load(tweet.getPhoto())
                    .apply(new RequestOptions().override(55, 55))
                    .into(civ_item_photo);
            tv_username.setText(tweet.getUsername());
            tv_content.setText(tweet.getContent());
        }
    }

    public interface OnTweetClickCallback {
        void onTweetClicked(Tweet tweet);
    }
}
