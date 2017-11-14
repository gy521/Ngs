package com.example.administrator.man_shoping.shouye.apapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class shouye_recyAdaptter extends RecyclerView.Adapter<shouye_recyAdaptter.MyviewHolder> {
    private Context context;
    private java.util.List<Data.DataBean.SubjectsBean.GoodsRelationListBean> List;

    public shouye_recyAdaptter(Context context, java.util.List<Data.DataBean.SubjectsBean.GoodsRelationListBean> list) {
        this.context = context;
        List = list;
    }
    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyviewHolder holder1 = new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.shouye_recy1, null));
        return  holder1;
    }

    @Override
    public int getItemCount() {
        Log.d("mylog", "getItemCount: "+List.size());

        return List.size();
    }

    @Override
    public void onBindViewHolder(shouye_recyAdaptter.MyviewHolder holder, int position) {
        holder.name.setText(List.get(position).getDescription());
        Uri uri=Uri.parse(List.get(position).getGoodsImage());
        holder.images.setImageURI(uri);
    }
    class MyviewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView images;
        TextView name;
        public MyviewHolder(View itemView) {
            super(itemView);
            images= (SimpleDraweeView) itemView.findViewById(R.id.images);
            name= (TextView) itemView.findViewById(R.id.name);
        }
    }
}
