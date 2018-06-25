package com.example.android.ongaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Song 1"));
        songs.add(new Song("Song 2"));
        songs.add(new Song("Song 3"));
        songs.add(new Song("Song 4"));
        songs.add(new Song("Song 5"));
        songs.add(new Song("Song 6"));
        songs.add(new Song("Song 7"));
        songs.add(new Song("Song 8"));
        songs.add(new Song("Song 9"));
        songs.add(new Song("Song 10"));
        songs.add(new Song("Song 11"));
        songs.add(new Song("Song 12"));

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.song_list);
        listView.setAdapter(adapter);
    }
}
