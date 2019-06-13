package com.example.dell_pc.myapplication.net;

import com.example.dell_pc.myapplication.bean.RecBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    String url = "https://api.apiopen.top/";

    @GET("getJoke?page=1&count=20&type=video")
    Observable<RecBean> getUrl();
}
