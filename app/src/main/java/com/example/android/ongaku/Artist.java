package com.example.android.ongaku;

public class Artist {

    private String mArtistName;
    private int mArtistImage;

    public Artist(String artistName, int artistImage) {
        mArtistName = artistName;
        mArtistImage = artistImage;
    }

    public String getArtistName() { return mArtistName; }
    public  int getArtistImage() { return mArtistImage; }

}
