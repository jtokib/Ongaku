package com.example.android.ongaku;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class SongActivity extends AppCompatActivity {

    //Create media player
    private MediaPlayer mediaPlayer;
    //Create audio manager
    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener audioManagerChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Permanent loss of audio focus
                        // Pause playback immediately
                        releaseMediaPlayer();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Pause playback
                        mediaPlayer.pause();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Lower the volume, keep playing
                        mediaPlayer.setVolume(2, 2);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mediaPlayer.start();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Song 1", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 2", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 3", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 4", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 5", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 6", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 7", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 8", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 9", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 10", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 11", R.raw.prettyhandsome_happyagain));
        songs.add(new Song("Song 12", R.raw.prettyhandsome_happyagain));

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = songs.get(position);
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(audioManagerChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(SongActivity.this, song.getSongId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            audioManager.abandonAudioFocus(audioManagerChangeListener);
        }
    }
}
