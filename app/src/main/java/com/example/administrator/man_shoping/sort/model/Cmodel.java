package com.example.administrator.man_shoping.sort.model;

import android.util.Log;

import com.example.administrator.man_shoping.sort.bean.Datebeanitem;
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

public class Cmodel implements  Cmode {
    @Override
    public void Cmodel() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.sotr_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<Datebeanitem> sort = apiServer.getGrind("mobile/index.php?act=goods_class");
        sort.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Datebeanitem>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Comdel", "onError: "+"111111111");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Datebeanitem datebeanitem) {
                        Log.d("Comdel", "onError: "+"3333333333");
                            childe.setChild(datebeanitem);
                    }
                });
    }
    public  interface  Childe{
        void setChild(Datebeanitem datebeanitem);
    }
    private Childe childe;
    public void setOnGround(Childe childe){
        this.childe=childe;
    }
}
