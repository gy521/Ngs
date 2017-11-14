package com.example.administrator.man_shoping.sort.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.man_shoping.R;


/**
 * description: $todo$
 * autour: BlueAmer
 * date: $date$ $time$
 * update: $date$
 * version: $version$
 */

public class ViewHolderA extends RecyclerView.ViewHolder {
    public TextView text;

    public ViewHolderA(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.text);
    }
}