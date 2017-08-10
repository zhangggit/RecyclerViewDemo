package com.example.zhanggang.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zhanggang.recyclerviewdemo.bean.Data;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 类作用：主类 网络请求 获取数据 xRecyclerView 下拉刷新 上啦加载
 * 时  间：2017/8/10 - 19:25.
 * 创建人：张刚
 */
public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener, MyAdaper.OnItemClickListener {

    @BindView(R.id.xrecyclerview)
    XRecyclerView xRecyclerView;
    private String url = "http://app.u17.com/v3/appV3_3/android/phone/list/commonComicList?argValue=23&argName=sort&argCon=0&android_id=4058040115108878&v=3330110&model=GT-P5210&come_from=Tg002&page=";
    int page = 1;
    private List<Data.DataBean.ReturnDataBean.ComicsBean> list = new ArrayList<>();
    private MyAdaper adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        //实现上啦加载下拉刷新监听
        xRecyclerView.setLoadingListener(this);


        LinearLayoutManager manager = new LinearLayoutManager(this);
        xRecyclerView.setLayoutManager(manager);

        //设置分割线 边框
        xRecyclerView.addItemDecoration(new MyLine(R.drawable.line, this));

        //设置适配器
        adaper = new MyAdaper(list, this);
        xRecyclerView.setAdapter(adaper);

        //实现点击子条目图片监听
        adaper.setListener(this);
    }

    private void initData() {
        //网络获取数据
        UrlOkHttp.sendOkHttpRequest(url + page, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Data data = new Gson().fromJson(response.body().string(), Data.class);
                list.addAll(data.getData().getReturnData().getComics());
            }
        });
    }

    //下拉刷新
    @Override
    public void onRefresh() {
        list.clear();
        initData();
        adaper.notifyDataSetChanged();
        xRecyclerView.refreshComplete();
    }

    //上啦加载
    @Override
    public void onLoadMore() {
        page++;
        initData();
        adaper.notifyDataSetChanged();
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public void OnItem(View view, int position) {
        Toast.makeText(this, "点击图片：" + position, Toast.LENGTH_SHORT).show();
    }
}
