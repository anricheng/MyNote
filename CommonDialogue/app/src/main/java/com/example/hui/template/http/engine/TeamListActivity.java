package com.example.hui.template.http.engine;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hui.template.R;
import com.example.hui.template.design.mode.BaseActivity;
import com.example.hui.template.http.engine.mode.TeamListResult;
import com.example.hui.template.http.engine.util.HttpCallBack;
import com.example.hui.template.http.engine.util.HttpUtils;
import com.example.hui.template.titlebar.CommonTitleBar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamListActivity extends BaseActivity {
    private ListView mListView;
    private List<TeamListResult.DataBean.TeamBean> mTeams;

    @Override
    protected void initTitle(CommonTitleBar titleBar) {
        // 这种方式还是比较麻烦     Builder 建造者模式 构建TitleBar
       titleBar.setTitle("工人列表！！！");
        titleBar.setRight("我的保单");
        titleBar.setRightOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeamListActivity.this,
                        "我的保单点击", Toast.LENGTH_SHORT).show();
            }
        });

        /*DefaultNavigationBar.Builder builder =
                new DefaultNavigationBar.Builder(
                        this, (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0));

        // 设置参数  监听事件  参数传递的方式可以任意
        builder.setTitle("工人列表！！！").setRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TeamListActivity.this,
                        "右边显示点击", Toast.LENGTH_SHORT).show();
            }
        }).setRight("右边显示");

        // 开发   项目业务逻辑打交道  功能代码不会反复写 实在用不来的  用原来的

        // 这个方法才会去构建参数
        builder.create();*/
    }

    @Override
    protected void initData() {
        // 1.请求数据
        requestListData();

        // 2.设置条目点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // parent 当前ListView  position 当前点击的条目位置  view 当前点击条目的View

                // 获取当前位置点击的Id
                String serviceId = mTeams.get(position).getService_id();
                // 把当前的ServiceId传到详情
            }
        });
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_team_list);
    }

    /*
     *  请求列表数据
     */
    private void requestListData() {// 1  2   70  40
        HttpUtils httpUtils = new HttpUtils();

        Map<String, String> param = new HashMap<>();
        param.put("appid", "1");

        httpUtils.post(param, "http://v2.ffu365.com/index.php?m=Api&c=Team&a=teamList",
                new HttpCallBack<TeamListResult>() {
                    @Override
                    public void onError() {

                    }

                    @Override
                    public void onSuccess(TeamListResult result) {
                        showListData(result.getData().getList());
                    }
                });


        /*RequestParams params = new RequestParams(
                "http://v2.ffu365.com/index.php?m=Api&c=Team&a=teamList");

        params.addParameter("appid", "1");// 公用属性

        // 1. xutils  不更新有Bug ?   OkHttp    会有一个性能更好的请求网络出现     根据需求必须要换
        // 2. 美团   必须要传的参数  10
        // HttpEngine
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", result);
                // 2.GSON解析请求到的数据
                Gson gson = new Gson();
                TeamListResult listResult = gson.fromJson(result, TeamListResult.class);
                showListData(listResult.getData().getList());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinished() {

            }
        });*/
    }

    /**
     * 3.显示列表数据
     */
    private void showListData(List<TeamListResult.DataBean.TeamBean> list) {
        // 数据返回之后一定要赋值
        mTeams = list;
        // 3.写一个适配器
        mListView.setAdapter(new TeamListTestAdapter(this, list));
    }
}
