package com.example.administrator.man_shoping.shouye.model;

import com.example.administrator.man_shoping.app;
import com.example.administrator.man_shoping.shouye.apapter.MyHomeApadter;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.example.administrator.man_shoping.utils.RetroFactory;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class Mymodel implements Imodel {
    @Override
    public void adptermodel() {
        Observable<Data> home = RetroFactory.getInstance().getHome();
        home.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Data data) {
                           changes.chang(data);
                    }
                });
    }
    public interface  OnChangeAdapter{
        void chang(Data data);
    }
    private  OnChangeAdapter  changes;

    public  void setInchange(OnChangeAdapter  changes){
        this.changes = changes;
    }
}
