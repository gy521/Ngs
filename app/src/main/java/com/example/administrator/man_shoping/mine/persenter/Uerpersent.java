package com.example.administrator.man_shoping.mine.persenter;


import com.example.administrator.man_shoping.mine.bean.Logs;
import com.example.administrator.man_shoping.mine.model.Mymodel;
import com.example.administrator.man_shoping.mine.view.Iview;

/**
 * Created by Administrator on 2017\11\13 0013.
 */

public class Uerpersent {
    private final Iview iview;
    private final Mymodel mymodel;

    public Uerpersent(Iview iview) {
        this.iview = iview;
        this.mymodel=new Mymodel();
    }
    public void start(String url,String mobile,String password){
         mymodel.MymodelOver(url, mobile, password);
        mymodel.setOnchanges(new Mymodel.ovderModel() {
            @Override
            public void setOnchang(Logs s) {
                if (s.getCode().equals("1")){
                    iview.overfairl();
                }else{
                    iview.overAdapter(s.getData().getMobile());
                }

            }
        });
    }
}
