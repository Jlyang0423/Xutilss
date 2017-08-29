package com.bawei.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String url="http://v.juhe.cn/toutiao/index?key=22a108244dbb8d1f49967cd74a0c144d";
    private List<Bean.ResultBean.DataBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
             xutilsfa();


            }



    class  adapter extends BaseAdapter{
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       View v=View.inflate(MainActivity.this,R.layout.lv_item,null);
        TextView tv=v.findViewById(R.id.text);
        ImageView img=v.findViewById(R.id.iv);
        tv.setText(list.get(i).title);
        ImageLoader.getInstance().displayImage(list.get(i).thumbnail_pic_s,img);
        return v;
    }
}

    private void xutilsfa() {
        RequestParams params=new RequestParams(url);
        params.addQueryStringParameter("username","abc");
        params.addQueryStringParameter("passward","123");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                System.out.println(result);
                Gson gson=new Gson();
                Bean ben=gson.fromJson(result.toString(),Bean.class);
                list = ben.result.data;
                ListView lv= (ListView) findViewById(R.id.listview);
                lv.setAdapter(new adapter());
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            //主动调用取消的方法
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
