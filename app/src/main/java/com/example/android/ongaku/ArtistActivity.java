package com.example.android.ongaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_grid);

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Artist 1", R.drawable.img_1));
        artists.add(new Artist("Artist 2", R.drawable.img_2));
        artists.add(new Artist("Artist 3", R.drawable.img_3));
        artists.add(new Artist("Artist 4", R.drawable.img_4));
        artists.add(new Artist("Artist 5", R.drawable.img_5));
        artists.add(new Artist("Artist 6", R.drawable.img_6));

        ArtistAdapter adapter = new ArtistAdapter(this, artists);
        final GridView gridView = (GridView) findViewById(R.id.artist_grid);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent artistIntent = new Intent(ArtistActivity.this, AlbumActivity.class);
                    startActivity(artistIntent);
            }
        });
    }
}
