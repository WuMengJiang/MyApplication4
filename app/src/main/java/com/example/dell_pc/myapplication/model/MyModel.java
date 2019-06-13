package com.example.dell_pc.myapplication.model;

import com.example.dell_pc.myapplication.bean.RecBean;
import com.example.dell_pc.myapplication.callback.CallBack;
import com.example.dell_pc.myapplication.net.MyServer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel implements MyM {
    @Override
    public void getUrl(final CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.url)
                .build();
        MyServer myServer = build.create(MyServer.class);
        Observable<RecBean> url = myServer.getUrl();
        url.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecBean recBean) {
                        callBack.onSuceess(recBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
