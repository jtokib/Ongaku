package com.example.android.ongaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_grid);

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Album 1", R.drawable.img_1));
        albums.add(new Album("Album 2", R.drawable.img_2));
        albums.add(new Album("Album 3", R.drawable.img_3));
        albums.add(new Album("Album 4", R.drawable.img_4));
        albums.add(new Album("Album 5", R.drawable.img_5));
        albums.add(new Album("Album 6", R.drawable.img_6));

        AlbumAdapter adapter = new AlbumAdapter(this, albums);
        GridView gridView = findViewById(R.id.album_grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songIntent = new Intent(AlbumActivity.this, SongActivity.class);
                startActivity(songIntent);
            }
        });

    }
}
