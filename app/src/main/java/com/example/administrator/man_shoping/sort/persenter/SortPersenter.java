package com.example.administrator.man_shoping.sort.persenter;

import com.example.administrator.man_shoping.sort.bean.DataleftBean;
import com.example.administrator.man_shoping.sort.model.Smyodel;
import com.example.administrator.man_shoping.sort.view.Sview;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class SortPersenter  {
    private final Sview sview;
    private final Smyodel smyodel;

    public SortPersenter(Sview sview) {
        this.sview = sview;
        this.smyodel=new Smyodel();
    }
    public void Sgroud(){
        smyodel.models();
        smyodel.setOnGround(new Smyodel.Groud() {
            @Override
            public void setGroud(DataleftBean dataleftBean) {
                sview.StortOver(dataleftBean);
            }
        });
    }
}
