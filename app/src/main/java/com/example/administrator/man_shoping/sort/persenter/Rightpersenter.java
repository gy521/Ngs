package com.example.administrator.man_shoping.sort.persenter;

import com.example.administrator.man_shoping.sort.bean.DatarightBean;
import com.example.administrator.man_shoping.sort.model.Rmyodel;
import com.example.administrator.man_shoping.sort.view.Rview;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class Rightpersenter {
    private final Rview rview;
    private final Rmyodel rmyodel;

    public Rightpersenter(Rview rview) {
        this.rview = rview;
        this.rmyodel=new Rmyodel();
    }
    public void Rigth(String gc_id,int postion){
        rmyodel.runsable(gc_id,postion);
        rmyodel.setOnGround(new Rmyodel.Right() {
            @Override
            public void setRight(DatarightBean datarightBean) {
                rview.rights(datarightBean);
            }
        });
    }
}
