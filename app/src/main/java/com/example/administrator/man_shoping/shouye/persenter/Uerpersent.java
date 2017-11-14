package com.example.administrator.man_shoping.shouye.persenter;

import com.example.administrator.man_shoping.shouye.bean.Data;
import com.example.administrator.man_shoping.shouye.model.Mymodel;
import com.example.administrator.man_shoping.shouye.view.Iview;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class Uerpersent  {
    public final Iview iview;
    public final Mymodel mymodel;

    public Uerpersent(Iview iview) {
        this.iview = iview;
        this.mymodel=new Mymodel();
    }


    public  void setAdapter(){
        mymodel.adptermodel();
        mymodel.setInchange(new Mymodel.OnChangeAdapter() {
            @Override
            public void chang(Data data) {
                iview.overAdpert(data);
            }
        });
    }
}
