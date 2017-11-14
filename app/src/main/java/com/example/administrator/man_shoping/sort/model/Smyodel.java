package com.example.administrator.man_shoping.sort.model;

import android.util.Log;

import com.example.administrator.man_shoping.sort.bean.DataleftBean;
import com.example.administrator.man_shoping.utils.Api;
import com.example.administrator.man_shoping.utils.ApiServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class Smyodel implements  Smodel {
    @Override
    public void models() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.sotr_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DataleftBean> sort = apiServer.getSort("mobile/index.php?act=goods_class");
        sort.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataleftBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Comdel", "onError: "+"77777777777");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DataleftBean dataleftBean) {
                       groud.setGroud(dataleftBean);
                    }
                });
    }
    public  interface  Groud{
        void setGroud(DataleftBean dataleftBean);
    }
    private Groud groud;
    public void setOnGround(Groud groud){
        this.groud=groud;
    }
}
