package com.example.administrator.man_shoping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.sort.adpater.MyAdapter_left;
import com.example.administrator.man_shoping.sort.adpater.MyAdapter_right;
import com.example.administrator.man_shoping.sort.bean.DataleftBean;
import com.example.administrator.man_shoping.sort.bean.DatarightBean;
import com.example.administrator.man_shoping.sort.bean.Datebeanitem;
import com.example.administrator.man_shoping.sort.persenter.Rightpersenter;
import com.example.administrator.man_shoping.sort.persenter.SortChilde;
import com.example.administrator.man_shoping.sort.persenter.SortPersenter;
import com.example.administrator.man_shoping.sort.view.Cview;
import com.example.administrator.man_shoping.sort.view.Rview;
import com.example.administrator.man_shoping.sort.view.Sview;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class Sort_two extends Fragment implements Cview,Sview,Rview{
    @BindView(R.id.type_rvleft)
    RecyclerView typeRvleft;
    @BindView(R.id.type_rvright)
    RecyclerView typeRvright;
    Unbinder unbinder;
    private SortChilde sortChilde;
    private SortPersenter sortPersenter;
    private Rightpersenter rightpersenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_srot, null);

        unbinder = ButterKnife.bind(this, view);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        //得到WindowManager
        WindowManager windowManager = getActivity().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        //得到屏幕宽
        int width = display.getWidth();
        //将RecyclerView宽设置为屏幕宽的1/5
        params.width = width * 1 / 5;
         typeRvleft.setLayoutParams(params);
        //得到RecyclerView布局管理器
        LinearLayoutManager leftLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        typeRvleft.setLayoutManager(leftLayoutManager);
        //得到RecyclerView布局管理器
        LinearLayoutManager rightLayoutManager = new LinearLayoutManager(getActivity());
        //RecyclerView设置布局管理器
        typeRvright.setLayoutManager(rightLayoutManager);
        sortChilde=new SortChilde(this);
        sortPersenter=new SortPersenter(this);
        rightpersenter=new Rightpersenter(this);
        sortChilde.stratChilde();
        sortPersenter.Sgroud();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void chiOver(Datebeanitem datebeanitem) {
        OnGetServerDateLisnter.getData(datebeanitem.getDatas().toString());
    }

    @Override
    public void StortOver(final DataleftBean dataleftBean) {
        final MyAdapter_left myAdapter_left= new MyAdapter_left(getActivity(), dataleftBean.getDatas().getClass_list());
        typeRvleft.setAdapter(myAdapter_left);
        myAdapter_left.setRecycleViewItemClickListener(new MyAdapter_left.OnRecycleViewItemClickListener() {
            @Override
            public void recycleViewItemClickListener(int position, View view, RecyclerView.ViewHolder viewHolder) {
                myAdapter_left.setTagPosition(position);
                 myAdapter_left.notifyDataSetChanged();
                 rightpersenter.Rigth(dataleftBean.getDatas().getClass_list().get(position).getGc_id(),position);
            }
        });
    }

    @Override
    public void rights(DatarightBean datarightBean) {
        MyAdapter_right myAdapter_right = new MyAdapter_right(getActivity(), datarightBean.getDatas().getClass_list());
        typeRvright.setAdapter(myAdapter_right);
    }

    public interface OnGetServerDateLisnter {
        void getData(String string);
    }
    private OnGetServerDateLisnter OnGetServerDateLisnter;
}
