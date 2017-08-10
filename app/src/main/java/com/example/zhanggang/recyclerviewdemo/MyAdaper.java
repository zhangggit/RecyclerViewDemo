package com.example.zhanggang.recyclerviewdemo;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.zhanggang.recyclerviewdemo.bean.Data;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * 类作用：
 * 时  间：2017/8/10 - 19:31.
 * 创建人：张刚
 */

public class MyAdaper extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    List<Data.DataBean.ReturnDataBean.ComicsBean> list;

    public MyAdaper(List<Data.DataBean.ReturnDataBean.ComicsBean> list) {
        this.list = list;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


}
