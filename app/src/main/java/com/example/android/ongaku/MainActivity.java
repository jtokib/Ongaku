package com.example.android.ongaku;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hiding title bar on main activity only. From https://stackoverflow.com/questions/14475109/remove-android-app-title-bar
        getSupportActionBar().hide();
        setContentView(R.layout.main_activity);

        //Find artists view
        TextView artists = (TextView) findViewById(R.id.artist_activity);
        //Set click listener on the view
        artists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artistsIntent);
            }
        });

        //Find album view
        TextView albums = (TextView) findViewById(R.id.albums_activity);
        //Set click listener on the view
        albums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

        //Find song view
        TextView songs = (TextView) findViewById(R.id.songs_activity);
        //Set click listener on the view
        songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongActivity.class);
                startActivity(songsIntent);
            }
        });
    }
}
