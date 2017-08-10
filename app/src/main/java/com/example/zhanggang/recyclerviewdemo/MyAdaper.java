package com.example.zhanggang.recyclerviewdemo;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zhanggang.recyclerviewdemo.bean.Data;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类作用：xRecyclerView 的适配器
 * 时  间：2017/8/10 - 19:31.
 * 创建人：张刚
 */

public class MyAdaper extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    List<Data.DataBean.ReturnDataBean.ComicsBean> list;
    Context context;

    public MyAdaper(List<Data.DataBean.ReturnDataBean.ComicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    //创建视图
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        return new ViewHolder(from.inflate(R.layout.item, parent, false));
    }

    //绑定数据
    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder mholder = (ViewHolder) holder;
            mholder.title.setText(list.get(position).getAuthor());
            mholder.name.setText(list.get(position).getName());
            mholder.description.setText(list.get(position).getDescription());
            Glide.with(context).load(list.get(position).getCover()).into(mholder.image);
            mholder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        listener.OnItem(view,position);
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    //ViewHolder  控件
    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.description)
        TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //回调接口
    public interface OnItemClickListener{
        void OnItem(View view,int position);
    }

}
