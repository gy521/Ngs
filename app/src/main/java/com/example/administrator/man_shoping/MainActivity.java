package com.example.administrator.man_shoping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.man_shoping.Intent_tiaozhuan.Log_tianzhuan;
import com.example.administrator.man_shoping.fragment.Four_mine;
import com.example.administrator.man_shoping.fragment.One;
import com.example.administrator.man_shoping.fragment.Sort_two;
import com.example.administrator.man_shoping.fragment.Therr_cart;
import com.example.administrator.man_shoping.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.shou)
    RadioButton shou;
    @BindView(R.id.dong)
    RadioButton dong;
    @BindView(R.id.cat)
    RadioButton cat;
    @BindView(R.id.my)
    RadioButton my;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll)
    LinearLayout ll;
    private One one;
    private Four_mine four_mine;
    private Sort_two sort_two;
    private android.app.FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        One one = new One();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.ll, one);
        fragmentTransaction.show(one);
        fragmentTransaction.commit();
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.shou:
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                One one = new One();
                fragmentTransaction.replace(R.id.ll, one);
                fragmentTransaction.commit();
                break;
            case R.id.dong:
                boolean b2 = (boolean) SharedPreferencesUtils.getParam(this,"bolean", false);
                if (b2){

                }else {
                    //SharedPreferencesUtils.getParam(this, "bolean", true);
                    Intent intent = new Intent(this, Log_tianzhuan.class);
                    startActivity(intent);
                }
                FragmentManager manager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = manager1.beginTransaction();
                Sort_two sort_two = new Sort_two();
                fragmentTransaction1.replace(R.id.ll, sort_two);
                fragmentTransaction1.commit();
                break;
            case R.id.cat:
                boolean b = (boolean) SharedPreferencesUtils.getParam(this,"bolean", false);
                if (b){

                }else {
                    //SharedPreferencesUtils.getParam(this, "bolean", true);
                    Intent intent = new Intent(this, Log_tianzhuan.class);
                    startActivity(intent);
                }
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = manager2.beginTransaction();
                Therr_cart therr_cart = new Therr_cart();
                fragmentTransaction2.replace(R.id.ll, therr_cart);
                fragmentTransaction2.commit();
                break;
            case R.id.my:
                boolean b1 = (boolean) SharedPreferencesUtils.getParam(this,"bolean", false);
                if (b1){

                }else {
                    SharedPreferencesUtils.getParam(this, "name","点击登录");
                    Intent intent = new Intent(this, Log_tianzhuan.class);
                    startActivity(intent);
                }
                FragmentManager manager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = manager3.beginTransaction();
                Four_mine four_mine = new Four_mine();
                fragmentTransaction3.replace(R.id.ll, four_mine);
                fragmentTransaction3.commit();
                break;
        }
    }

}
