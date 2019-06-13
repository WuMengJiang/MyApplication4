package com.example.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Banner bann;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        bann = (Banner) findViewById(R.id.bann);
        strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.mipmap.ic_launcher);
        strings.add("http://wimg.spriteapp.cn/profile/large/2018/06/23/5b2dc5ace8486_mini.jpg");
        strings.add("http://wimg.spriteapp.cn/profile/large/2019/03/26/5c99f6da0d0c3_mini.jpg");
        strings.add("http://wimg.spriteapp.cn/picture/2019/0607/5cf9d60295b99_wpd.jpg");

        bann.setImages(strings).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(MainActivity.this).load(path).into(imageView);
            }
        }).setDelayTime(3000).start();

    }
}
