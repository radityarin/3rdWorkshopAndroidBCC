package com.example.workshoprecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tweet implements Parcelable {

    private String photo, username, content;

    public Tweet(){

    }

    public String getPhoto() {
        return photo;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.photo);
        dest.writeString(this.username);
        dest.writeString(this.content);
    }

    protected Tweet(Parcel in) {
        this.photo = in.readString();
        this.username = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<Tweet> CREATOR = new Parcelable.Creator<Tweet>() {
        @Override
        public Tweet createFromParcel(Parcel source) {
            return new Tweet(source);
        }

        @Override
        public Tweet[] newArray(int size) {
            return new Tweet[size];
        }
    };
}
