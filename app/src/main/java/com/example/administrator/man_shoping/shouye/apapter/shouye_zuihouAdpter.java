package com.example.administrator.man_shoping.shouye.apapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class shouye_zuihouAdpter extends RecyclerView.Adapter<shouye_zuihouAdpter.MyViewHolder> {
    private Context context;
    private List<Data.DataBean.SubjectsBean.GoodsRelationListBean> list;
    private   List<Integer> mHeights;
    public shouye_zuihouAdpter(Context context, List<Data.DataBean.SubjectsBean.GoodsRelationListBean> list) {
        this.context = context;
        this.list = list;
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            mHeights.add( (int) (100 + Math.random() * 300));
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public shouye_zuihouAdpter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_zuihourecy, null));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.xiang_name.getLayoutParams();
        ViewGroup.LayoutParams lp1 = holder.img_xiang.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.xiang_name.setLayoutParams(lp);
        holder.img_xiang.setLayoutParams(lp1);
        holder.xiang_name.setText(list.get(position).getDescription());
        Uri uri=Uri.parse(list.get(position).getGoodsImage());
        holder.img_xiang.setImageURI(uri);
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img_xiang;
        TextView xiang_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            xiang_name= (TextView) itemView.findViewById(R.id.xiang_name);
            img_xiang= (SimpleDraweeView) itemView.findViewById(R.id.img_xiang);
        }
    }
}
