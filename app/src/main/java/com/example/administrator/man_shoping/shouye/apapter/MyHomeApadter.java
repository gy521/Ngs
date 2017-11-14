package com.example.administrator.man_shoping.shouye.apapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.man_shoping.GlideImageLoader;
import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class MyHomeApadter extends RecyclerView.Adapter {
    private int tye_i0=0;
    private int tye_i1=1;
    private int tye_i2=2;
    private int tye_i3=3;
    private int tye_i4=4;
    private int tye_i5=5;
    private int tye_i6=6;
    private int tye_i7=7;
    private int tye_i8=8;
    private Data list;
    private Context context;
    private List<String> lists;
    private List<String> list2;
    public MyHomeApadter(Data list, Context context) {
        this.list = list;
        this.context = context;
        lists=new ArrayList<>();
        list2=new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == tye_i0) {
            for (int i = 0; i < list.getData().getAd1().size(); i++) {
                String image = list.getData().getAd1().get(i).getImage();
                lists.add(image);
            }
            MyviewHolder1 holderOne = (MyviewHolder1) holder;
            holderOne.bane.setImageLoader(new GlideImageLoader());
            holderOne.bane.setImages(lists);
            holderOne.bane.start();
        }else if (position==tye_i1){
            MyviewHolder2 holdertwo= (MyviewHolder2)holder;
            holdertwo.name_shou.setText(list.getData().getAd5().get(0).getTitle());
            Uri uri=Uri.parse(list.getData().getAd5().get(0).getImage());
            ((MyviewHolder2) holder).img_shou1.setImageURI(uri);
            Uri uri1=Uri.parse(list.getData().getAd5().get(1).getImage());
            holdertwo.name_shou1.setText(list.getData().getAd5().get(1).getTitle());
            holdertwo.img_shou2.setImageURI(uri1);
            holdertwo.name_shou2.setText(list.getData().getAd5().get(2).getTitle());
            Uri uri2=Uri.parse(list.getData().getAd5().get(2).getImage());
            ((MyviewHolder2) holder).img_shou3.setImageURI(uri2);
            holdertwo.name_shou3.setText(list.getData().getAd5().get(3).getTitle());
            Uri uri3=Uri.parse(list.getData().getAd5().get(3).getImage());
            holdertwo.img_shou4.setImageURI(uri3);
        }else if(position==tye_i2){
            MyviewHolder3 holder3= (MyviewHolder3) holder;
            holder3.re.setText("热门活动");
            holder3.teacher_countdownView.start(50000000);
        }else if(position==tye_i3){
            MyviewHolder4 holder4= (MyviewHolder4) holder;
            Uri uri=Uri.parse(list.getData().getActivityInfo().getActivityInfoList().get(0).getActivityImg());
            holder4.shou_img_da.setImageURI(uri);
            Uri uri1=Uri.parse(list.getData().getActivityInfo().getActivityInfoList().get(1).getActivityImg());
            holder4.shou_img_da1.setImageURI(uri1);
            Uri uri2=Uri.parse(list.getData().getActivityInfo().getActivityInfoList().get(0).getActivityImg());
            holder4.shou_img_da2.setImageURI(uri2);
            Uri uri3=Uri.parse(list.getData().getActivityInfo().getActivityInfoList().get(1).getActivityImg());
            holder4.shou_img_da3.setImageURI(uri3);
        }else if(position==tye_i4){
            MyviewHolder5 holder5= (MyviewHolder5) holder;
            holder5.shou_remenzhuanti.setText("热门专题");
        }else if(position==tye_i5){
            for(int i=0;i<list.getData().getSubjects().size();i++){
                String images =list.getData().getSubjects().get(i).getImage();
                android.util.Log.d("sss",images);
                list2.add(images);
            }
            MyviewHolder6  holder6= (MyviewHolder6) holder;
            holder6.shou_bane2.setImageLoader(new GlideImageLoader());
            holder6.shou_bane2.setImages(list2);
            holder6.shou_bane2.start();
        }else if (position==tye_i6){
            MyviewHolder7  holder7= (MyviewHolder7) holder;
            holder7.recy_list.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            holder7.recy_list.setAdapter(new shouye_recyAdaptter(context,list.getData().getSubjects().get(0).getGoodsRelationList()));
        } else if (position==tye_i7){
            MyviewHolder8  holder8= (MyviewHolder8) holder;
            holder8.cai.setText("猜你喜欢");
        }else if (position==tye_i8){
            MyviewHolder9  holder9= (MyviewHolder9) holder;
            holder9.recy_listview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            holder9.recy_listview.setAdapter(new shouye_zuihouAdpter(context,list.getData().getSubjects().get(0).getGoodsRelationList()));
        }

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder=null;
        if (viewType==tye_i0){
            view=View.inflate(context,R.layout.shouye_banner,null);
            return  new MyviewHolder1(view);
        } else if (viewType==tye_i1){
            view=View.inflate(context,R.layout.shouye_type1,null);
            return  new MyviewHolder2(view);
        }else if(viewType==tye_i2){
            view=View.inflate(context,R.layout.shouye_remen,null);
            return  new MyviewHolder3(view);
        }else if(viewType==tye_i3){
            view=View.inflate(context,R.layout.shouye_yaoqiu,null);
            return  new MyviewHolder4(view);
        }else if(viewType==tye_i4){
            view=View.inflate(context,R.layout.shouye_remenzhuanti,null);
            return  new MyviewHolder5(view);
        }else if (viewType==tye_i5){
            view=View.inflate(context,R.layout.shouye_baner2,null);
            return new MyviewHolder6(view);
        }else if(viewType==tye_i6){
            view=View.inflate(context,R.layout.shouye_xiangqing,null);
            return new MyviewHolder7(view);
        } else if(viewType==tye_i7){
            view=View.inflate(context,R.layout.shouye_cai,null);
            return new MyviewHolder8(view);
        }else if(viewType==tye_i8){
            view=View.inflate(context,R.layout.shouye_zuihou,null);
            return new MyviewHolder9(view);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return  tye_i0;
        }else if(position==1){
            return  tye_i1;
        }else if(position==2){
            return  tye_i2;
        }else if(position==3){
            return  tye_i3;
        }else if(position==4){
            return  tye_i4;
        }else if(position==5){
            return  tye_i5;
        }else if(position==6){
            return  tye_i6;
        }else if (position==7){
            return  tye_i7;
        }else if(position==8){
            return  tye_i8;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 9;
    }
    class  MyviewHolder1 extends RecyclerView.ViewHolder{
        Banner bane;
        public MyviewHolder1(View itemView) {
            super(itemView);
            bane= (Banner) itemView.findViewById(R.id.shou_baner);
        }
    }
    class   MyviewHolder2 extends RecyclerView.ViewHolder{
        SimpleDraweeView img_shou1,img_shou2,img_shou3,img_shou4;
        TextView name_shou,name_shou2,name_shou1,name_shou3;
        public MyviewHolder2(View itemView) {
            super(itemView);
            img_shou1= (SimpleDraweeView) itemView.findViewById(R.id.img_shou1);
            name_shou= (TextView) itemView.findViewById(R.id.name_shou);
            img_shou2= (SimpleDraweeView) itemView.findViewById(R.id.img_shou2);
            name_shou1= (TextView) itemView.findViewById(R.id.name_shou1);
            img_shou3= (SimpleDraweeView) itemView.findViewById(R.id.img_shou3);
            name_shou2= (TextView) itemView.findViewById(R.id.name_shou2);
            img_shou4= (SimpleDraweeView) itemView.findViewById(R.id.img_shou4);
            name_shou3= (TextView) itemView.findViewById(R.id.name_shou3);
        }
    }
    class  MyviewHolder3 extends  RecyclerView.ViewHolder{
        TextView re;
        CountdownView teacher_countdownView;
        public MyviewHolder3(View itemView) {
            super(itemView);
            re= (TextView) itemView.findViewById(R.id.re);
            teacher_countdownView= (CountdownView) itemView.findViewById(R.id.teacher_countdownView);
        }
    }
    class  MyviewHolder4 extends RecyclerView.ViewHolder{
        SimpleDraweeView shou_img_da,shou_img_da1,shou_img_da2,shou_img_da3;
        public MyviewHolder4(View itemView) {
            super(itemView);
            shou_img_da= ( SimpleDraweeView) itemView.findViewById(R.id.shou_img_da);
            shou_img_da1= ( SimpleDraweeView) itemView.findViewById(R.id.shou_img_da1);
            shou_img_da2= ( SimpleDraweeView) itemView.findViewById(R.id.shou_img_da2);
            shou_img_da3= ( SimpleDraweeView) itemView.findViewById(R.id.shou_img_da3);
        }
    }
    class  MyviewHolder5 extends RecyclerView.ViewHolder{
        TextView shou_remenzhuanti;
        public MyviewHolder5(View itemView) {
            super(itemView);
            shou_remenzhuanti= (TextView) itemView.findViewById(R.id.shou_remenzhuanti);
        }
    }

    class  MyviewHolder6 extends RecyclerView.ViewHolder{
        Banner shou_bane2;
        public MyviewHolder6(View itemView) {
            super(itemView);
            shou_bane2= (Banner) itemView.findViewById(R.id.shou_bane2);
        }
    }
    class MyviewHolder7 extends RecyclerView.ViewHolder{
        RecyclerView recy_list;
        public MyviewHolder7(View itemView) {
            super(itemView);
            recy_list= (RecyclerView) itemView.findViewById(R.id.recy_lists);
        }
    }
    class MyviewHolder8 extends RecyclerView.ViewHolder{
        TextView cai;
        public MyviewHolder8(View itemView) {
            super(itemView);
            cai= (TextView) itemView.findViewById(R.id.cai);
        }
    }
    class MyviewHolder9 extends RecyclerView.ViewHolder{
        RecyclerView  recy_listview;
        public MyviewHolder9(View itemView) {
            super(itemView);
            recy_listview= (RecyclerView) itemView.findViewById(R.id.recy_listview);
        }
    }
}
