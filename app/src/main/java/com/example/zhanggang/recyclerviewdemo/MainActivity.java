package com.example.zhanggang.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.xrecyclerview)
    XRecyclerView xRecyclerView;
    private String url="http://app.u17.com/v3/appV3_3/android/phone/list/commonComicList?argValue=23&argName=sort&argCon=0&android_id=4058040115108878&v=3330110&model=GT-P5210&come_from=Tg002&page=";
    int page=1;
    private List<Data.DataBean.ReturnDataBean.ComicsBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();


    }

    private void initData() {
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


}
