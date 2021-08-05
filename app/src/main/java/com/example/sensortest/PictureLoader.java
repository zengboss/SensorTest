package com.example.sensortest;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import android.os.Handler;


public class PictureLoader {
    private ImageView loadImg;
    private String imgUrl;
    private byte[] picByte;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){

    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };
}
