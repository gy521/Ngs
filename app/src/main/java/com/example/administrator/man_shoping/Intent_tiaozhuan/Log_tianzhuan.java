package com.example.administrator.man_shoping.Intent_tiaozhuan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.man_shoping.R;
import com.example.administrator.man_shoping.mine.persenter.Uerpersent;
import com.example.administrator.man_shoping.mine.view.Iview;
import com.example.administrator.man_shoping.utils.Api;
import com.example.administrator.man_shoping.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.administrator.man_shoping.R.id.log_name;
import static com.example.administrator.man_shoping.R.id.log_pass;

public class Log_tianzhuan extends AppCompatActivity  implements Iview{

    @BindView(R.id.img_my)
    ImageView imgMy;
    @BindView(log_name)
    EditText logName;
    @BindView(R.id.log2)
    LinearLayout log2;
    @BindView(log_pass)
    EditText logPass;
    @BindView(R.id.log3)
    LinearLayout log3;
    @BindView(R.id.but)
    Button but;
    @BindView(R.id.zhuche)
    TextView zhuche;
    @BindView(R.id.activity_log_tianzhuan)
    RelativeLayout activityLogTianzhuan;
     private Uerpersent uerpersent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_tianzhuan);
        ButterKnife.bind(this);
        uerpersent=new Uerpersent(this);
    }

    @OnClick({R.id.but, R.id.zhuche})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but:
                final String string =logName.getText().toString();
                String string1 = logPass.getText().toString();
                if(string.equals("")||string1.equals("")){
                    Toast.makeText(Log_tianzhuan.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }
                uerpersent.start(Api.Log_URL,string,string1);
                break;
            case R.id.zhuche:
                Intent intent = new Intent(Log_tianzhuan.this, Zhuce.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void overAdapter(String s) {
        Toast.makeText(Log_tianzhuan.this,"登录成功",Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(Log_tianzhuan.this,"bolean",true);
        SharedPreferencesUtils.setParam(Log_tianzhuan.this,"name",s);
        finish();
    }

    @Override
    public void overfairl() {
        Toast.makeText(Log_tianzhuan.this,"天呐，用户不存在,请先注册",Toast.LENGTH_SHORT).show();
    }
}
