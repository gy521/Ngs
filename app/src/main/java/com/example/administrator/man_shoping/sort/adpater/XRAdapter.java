package com.example.administrator.man_shoping.sort.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.sort.bean.HomeBean;
import com.example.administrator.man_shoping.sort.utils.GlideImaGlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * description: $todo$
 * autour: BlueAmer
 * date: $date$ $time$
 * update: $date$
 * version: $version$
 */

public class XRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
   HomeBean.DataBean list;
    Context mcontext;
    ArrayList  mlist;

    //枚举类型
      private  enum  Item_Type{

          Typeone ,Typetwo,Typethree,Typefour

    }
    public XRAdapter(Context context, HomeBean.DataBean data) {
        this.mcontext=context;
        this.list=data;

    }
    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType :不同ItemView的类型
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Item_Type.Typeone.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_a, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        } else if (viewType == Item_Type.Typetwo.ordinal()) {

            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_b, null);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.Typethree.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_c, null);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typefour.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_d, null);
            ViewHolderD viewHolder = new ViewHolderD(mView);
            return viewHolder;
        }
        return null;
    }

    /**
     * 绑定数据：可以直接拿到已经绑定控件的Viewholder对象
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderA) {
            mlist=new ArrayList();
            for(int i=0;i<list.getAd1().size();i++){
                mlist.add(list.getAd1().get(i).getImage());
            }
            //设置图片加载器
            ((ViewHolderA) holder).mbanner.setImageLoader(new GlideImaGlideImageLoader());
            ((ViewHolderA) holder).mbanner.setImages(mlist);
            ((ViewHolderA) holder).mbanner.start();

        } else if (holder instanceof ViewHolderB) {
           ((ViewHolderB) holder).text.setText(list.getDefaultGoodsList().get(position).getGoods_name() + "------样式二");
        } else if (holder instanceof ViewHolderC) {
            ((ViewHolderC) holder).text.setText(list.getDefaultGoodsList().get(position).getGoods_name()+ "------样式三");
        }else if (holder instanceof ViewHolderD) {
            ((ViewHolderD) holder).text.setText(list.getDefaultGoodsList().get(position).getGoods_name()+ "------样式4");
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
    //返回值赋值给onCreateViewHolder的参数 viewType
    @Override
    public int getItemViewType(int position) {
       // return super.getItemViewType(position);

        if (position == 0) {
            return Item_Type.Typeone.ordinal();
        } else if (position == 1) {
            return Item_Type.Typetwo.ordinal();
        } else if (position == 2) {
            return Item_Type.Typethree.ordinal();
        }else if (position == 3) {
            return Item_Type.Typefour.ordinal();
        }
        return -1;


    }
    class ViewHolderA extends RecyclerView.ViewHolder {
        public Banner mbanner;

        public ViewHolderA(View itemView) {
            super(itemView);

            mbanner = (Banner) itemView.findViewById(R.id.mybanner);
        }
    }


    class ViewHolderB extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolderB(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tvb);
        }
    }

    class ViewHolderC extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolderC(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tvc);
        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder {

        public TextView text;

        public ViewHolderD(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tvd);
        }
    }
}
