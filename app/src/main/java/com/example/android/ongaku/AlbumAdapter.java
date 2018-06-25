package com.example.android.ongaku;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> artists) { super(context,0, artists);}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.ongaku_item,parent,false);
        }

        Album currentArtist = getItem(position);

        ImageView albumImageView = (ImageView) gridItemView.findViewById(R.id.a_image);
        albumImageView.setImageResource(currentArtist.getAlbumImage());

        TextView albumTextView = (TextView) gridItemView.findViewById(R.id.a_name);
        albumTextView.setText(currentArtist.getAlbumTitle());

        return gridItemView;
    }
}
