package com.hudeing.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import com.hudeing.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaollaFragment extends Fragment implements View.OnClickListener {
    private ImageButton buttonYoshi, buttonInterrogation;
    private MediaPlayer mediaPlayer;
    private int length = 0;

    public PaollaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paolla, container, false);

        buttonYoshi = view.findViewById(R.id.buttonYoshi);
        buttonInterrogation = view.findViewById(R.id.buttonInterrogation);
        buttonYoshi.setOnClickListener(this);
        buttonInterrogation.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonYoshi:
                tocarSom(R.raw.silly_farts);
                break;
            case R.id.buttonInterrogation:
                tocarSom(R.raw.pula_fogueira);
                break;
        }
    }

    public void tocarSom(int raw) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getActivity(), raw);
            mediaPlayer.start();
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null)
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                this.length = mediaPlayer.getCurrentPosition();
            }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mediaPlayer != null)
            if(length != 0) {
                mediaPlayer.seekTo(length);
                mediaPlayer.start();
                this.length = 0;
            }

    }
}
