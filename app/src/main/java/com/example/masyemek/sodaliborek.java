package com.example.masyemek;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class sodaliborek extends AppCompatActivity {

    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sodaliborek);

        videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sodaliborek);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        videoView.setMediaController(mediaController);
    }
}
