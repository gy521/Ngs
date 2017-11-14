package com.example.administrator.man_shoping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.man_shoping.Intent_tiaozhuan.MyMessage;
import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class Four_mine extends Fragment {
    @BindView(R.id.tu1)
    ImageView tu1;
    @BindView(R.id.my5)
    LinearLayout my5;
    Unbinder unbinder;
    @BindView(R.id.deng)
    TextView deng;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine, null);
        unbinder = ButterKnife.bind(this, view);
         final String s = (String) SharedPreferencesUtils.getParam(getActivity(),"name","");
         deng.setText(s);
         tu1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getActivity(), MyMessage.class);
                 intent.putExtra("name",s);
                 startActivity(intent);
             }
         });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



}
