package com.example.administrator.man_shoping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.shouye.apapter.MyHomeApadter;
import com.example.administrator.man_shoping.shouye.bean.Data;
import com.example.administrator.man_shoping.shouye.persenter.Uerpersent;
import com.example.administrator.man_shoping.shouye.view.Iview;
import com.example.administrator.man_shoping.utils.RetroFactory;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017\11\8 0008.
 */

public class One extends Fragment implements Iview{
    @BindView(R.id.er)
    ImageView er;
    @BindView(R.id.recy_list)
    XRecyclerView recyList;
    Unbinder unbinder;
     private Uerpersent uerpersent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shouye, null);
        unbinder = ButterKnife.bind(this, view);
        er.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CaptureActivity.class));
            }
        });
        uerpersent= new Uerpersent(this);
        uerpersent.setAdapter();
        recyList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                recyList.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyList.refreshComplete();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //二维码回传
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==getActivity().RESULT_OK){
            Bundle bundle=data.getExtras();
            String result=bundle.getString("result");
            Toast.makeText(getActivity(),result,Toast.LENGTH_SHORT).show();
        }else if(resultCode==getActivity().RESULT_CANCELED){
            Toast.makeText(getActivity(),"扫描出错",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void overAdpert(Data data) {
        MyHomeApadter myHomeApadter = new MyHomeApadter(data, getActivity());
        recyList.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyList.setAdapter(myHomeApadter);
    }
}
