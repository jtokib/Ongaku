package com.example.android.ongaku;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    SongAdapter(Activity context, ArrayList<Song> artists) {
        super(context, 0, artists);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item,parent,false);
        }

        Song currentArtist = getItem(position);

        TextView albumTextView = gridItemView.findViewById(R.id.song_title);
        albumTextView.setText(currentArtist.getSongTitle());

        return gridItemView;
    }
}
