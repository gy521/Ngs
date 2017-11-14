package com.example.administrator.man_shoping.Intent_tiaozhuan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.mine.persenter.Zhupersenter;
import com.example.administrator.man_shoping.mine.view.Zview;
import com.example.administrator.man_shoping.utils.Api;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.administrator.man_shoping.R.id.zhu_name;
import static com.example.administrator.man_shoping.R.id.zhu_pass;

public class Zhuce extends AppCompatActivity implements Zview{

    @BindView(zhu_name)
    EditText zhuName;
    @BindView(zhu_pass)
    EditText zhuPass;
    @BindView(R.id.zhuce1)
    Button zhuce1;
    @BindView(R.id.activity_zhuce)
    RelativeLayout activityZhuce;
     private Zhupersenter zhupersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
        zhupersenter=new Zhupersenter(this);
    }

    @OnClick(R.id.zhuce1)
    public void onViewClicked() {
        final String string = zhuName.getText().toString();
        final String string1 = zhuPass.getText().toString();
        if(string.equals("")||string1.equals("")){
            Toast.makeText(Zhuce.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
        }
        zhupersenter.zhustart(Api.Zhu_URL,string,string1);
    }

    @Override
    public void zhusucess() {
        Toast.makeText(Zhuce.this,"注册成功",Toast.LENGTH_SHORT).show();
         finish();
    }

    @Override
    public void zhufarile() {
        Toast.makeText(Zhuce.this,"天呐用户已经存在",Toast.LENGTH_SHORT).show();
    }
}
