package com.example.administrator.man_shoping.sort.persenter;

import com.example.administrator.man_shoping.sort.bean.Datebeanitem;
import com.example.administrator.man_shoping.sort.model.Cmodel;
import com.example.administrator.man_shoping.sort.view.Cview;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class SortChilde {
    private final Cview cview;
    private final Cmodel cmodel;

    public SortChilde(Cview cview) {
        this.cview = cview;
        this.cmodel=new Cmodel();
    }
    public void stratChilde(){
        cmodel.Cmodel();
        cmodel.setOnGround(new Cmodel.Childe() {
            @Override
            public void setChild(Datebeanitem datebeanitem) {
                cview.chiOver(datebeanitem);
            }
        });
    }
}
