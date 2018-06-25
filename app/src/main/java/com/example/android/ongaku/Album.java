package com.example.android.ongaku;

public class Album {

    private String mAlbumTitle;
    private int mAlbumImage;

    public Album(String albumTitle, int albumImage) {
        mAlbumTitle = albumTitle;
        mAlbumImage = albumImage;
    }

    public String getAlbumTitle() { return mAlbumTitle; }
    public int getAlbumImage() { return mAlbumImage; }
}
