package com.example.administrator.man_shoping.sort.model;

import android.util.Log;

import com.example.administrator.man_shoping.sort.bean.DatarightBean;
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

public class Rmyodel implements  Rmodel {
    @Override
    public void runsable(String gc_id,int postion) {
        Retrofit retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Api.sotr_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<DatarightBean> getright = apiServer.getright("/mobile/index.php?act=goods_class&gc_id="+gc_id);
        getright.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatarightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Comdel", "onError: "+"444444");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DatarightBean datarightBean) {
                           groud.setRight(datarightBean);
                    }
                });
    }
    public  interface  Right{
        void setRight(DatarightBean datarightBean);
    }
    private Right groud;
    public void setOnGround(Right groud){
        this.groud=groud;
    }
}
