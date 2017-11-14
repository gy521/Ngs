package com.example.administrator.man_shoping;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017\11\9 0009.
 */

public class GlideImageLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
