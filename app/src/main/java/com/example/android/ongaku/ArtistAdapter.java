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

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(Activity context, ArrayList<Artist> artists) { super(context,0, artists);}
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.ongaku_item,parent,false);
        }

        Artist currentArtist = getItem(position);

        ImageView imageView = (ImageView) gridItemView.findViewById(R.id.a_image);
        imageView.setImageResource(currentArtist.getArtistImage());

        TextView artistTextView = (TextView) gridItemView.findViewById(R.id.a_name);
        artistTextView.setText(currentArtist.getArtistName());

        return gridItemView;
    }
}
