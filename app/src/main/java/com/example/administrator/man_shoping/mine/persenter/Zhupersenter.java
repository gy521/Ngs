package com.example.administrator.man_shoping.mine.persenter;

import com.example.administrator.man_shoping.mine.bean.Zhu;
import com.example.administrator.man_shoping.mine.model.ZhuMyodel;
import com.example.administrator.man_shoping.mine.view.Zview;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class Zhupersenter {
    private final  Zview zview;
    private final ZhuMyodel zhuMyodel;

    public Zhupersenter(Zview zview) {
        this.zview = zview;
        this.zhuMyodel=new ZhuMyodel();
    }
    public void zhustart(String url,String mobile,String password){
        zhuMyodel.zhuLog(url,mobile,password);
        zhuMyodel.setChangce(new ZhuMyodel.setOverzhu() {
            @Override
            public void zhuOver(Zhu zhu) {
                if (zhu.getCode().equals("0")){
                    zview.zhusucess();
                }else{
                    zview.zhufarile();
                }
            }
        });
    }
}
