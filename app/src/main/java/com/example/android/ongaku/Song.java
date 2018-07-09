package com.example.android.ongaku;

public class Song {

    private String mSongTitle;
    private int mSongId;

    Song(String songTitle, int songId) {
        mSongTitle = songTitle;
        mSongId = songId;
    }

    public String getSongTitle() { return mSongTitle; }

    public int getSongId() {
        return mSongId;
    }

}
