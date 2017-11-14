package com.example.administrator.man_shoping.utils;

import com.example.administrator.man_shoping.mine.bean.Logs;
import com.example.administrator.man_shoping.mine.bean.Zhu;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.example.administrator.man_shoping.sort.bean.DataleftBean;
import com.example.administrator.man_shoping.sort.bean.DatarightBean;
import com.example.administrator.man_shoping.sort.bean.DateGridBean;
import com.example.administrator.man_shoping.sort.bean.Datebeanitem;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
   //首页
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<Data> getHome();
    //登录
    @POST
    Observable<Logs> getLog(@Url String url, @QueryMap Map<String,String> map);
    @POST
   Observable<Zhu> getZhu(@Url String url,@QueryMap Map<String,String> map);
    //分类
    @GET()
    Observable<DataleftBean> getSort(@Url String url);
   @GET()
    Observable<Datebeanitem> getGrind(@Url String url);
    @GET
    Observable<DatarightBean> getright(@Url String url);
    @GET()
    Observable<DateGridBean> getgird(@Url String url);

}
