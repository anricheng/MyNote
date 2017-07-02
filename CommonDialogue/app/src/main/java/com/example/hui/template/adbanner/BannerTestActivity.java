package com.example.hui.template.adbanner;

import android.content.Intent;

import com.example.hui.template.R;
import com.example.hui.template.adbanner.mode.CompanyDetailResult;
import com.example.hui.template.design.mode.BaseActivity;
import com.example.hui.template.http.engine.util.HttpCallBack;
import com.example.hui.template.http.engine.util.HttpUtils;
import com.example.hui.template.ioc.view.ViewById;
import com.example.hui.template.photo.view.PhotoViewActivity;
import com.example.hui.template.titlebar.CommonTitleBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hui on 2016/10/11.
 */
public class BannerTestActivity extends BaseActivity{

    @ViewById(R.id.banner_view)
    private AdBannerRollPagerView mBannerView;

    private String[] items = {"http://img3.imgtn.bdimg.com/it/u=3355235453,2337163232&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=549778725,2120265236&fm=21&gp=0.jpg",
            "http://img3.imgtn.bdimg.com/it/u=3355235453,2337163232&fm=21&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=549778725,2120265236&fm=21&gp=0.jpg"};


    @Override
    protected void initTitle(CommonTitleBar titleBar) {

    }

    @Override
    protected void initData() {
        // http://120.76.215.116:8030/varyjia-soa/ws/rest/company/companyOne?appid=1&companyId=9&userId=52

        HttpUtils httpUtils = new HttpUtils();

        Map<String,String> params = new HashMap<>();
        params.put("appid","1");
        params.put("companyId","9");
        params.put("userId","52");

        // Map 集合  Url 路径   HttpCallBack 回调
        httpUtils.post(params, "http://120.76.215.116:8030/varyjia-soa/ws/rest/company/companyOne",
                new HttpCallBack<CompanyDetailResult>() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(CompanyDetailResult result) {
                // 成功的回调
                showBannerData(result.getData().getBanners());
            }
        });

    }

    /**
     * 显示Banner轮播图数据
     * @param banners
     */
    private void showBannerData(final List<CompanyDetailResult.DataBean.BannersBean> banners) {

        mBannerView.setAdapter(new AdBannerAdapter() {
            @Override
            public int getCount() {
                return banners.size();
            }

            @Override
            public String getImageUrl(int position) {
                return banners.get(position).getBanner();
            }
        });

        mBannerView.startRoll();

        /*mBannerView.setItemCutByDuration(3000);
        mBannerView.setItemCutDuration(500);*/

        // banners 里面的图片封装到集合
        final ArrayList<String> bannersImages = getBannerImages(banners);


       // 设置点击事件
        mBannerView.setOnBannerItemClickListener(new AdBannerRollPager.BannerItemClickListener() {
            @Override
            public void clickItem(int position) {
                // 返回position 点击的是第几个位置
                // Toast.makeText(BannerTestActivity.this,position+"",Toast.LENGTH_SHORT).show();

                // 1. new Intent
                Intent intent = new Intent(BannerTestActivity.this, PhotoViewActivity.class);

                // 2. 传递参数
                // 2.1 传当前位置
                intent.putExtra(PhotoViewActivity.CURRENT_POINT_KEY, position);
                // 2.2 传总的图片路径  ArrayList
                intent.putStringArrayListExtra(PhotoViewActivity.IMAGE_URL_LIST_KEY, bannersImages);

                startActivity(intent);
            }
        });
    }

    /**
     * banners 里面的图片封装到集合
     */
    private ArrayList<String> getBannerImages(List<CompanyDetailResult.DataBean.BannersBean> banners) {
        ArrayList<String> images = new ArrayList<>();
        for(CompanyDetailResult.DataBean.BannersBean item:banners){
            images.add(item.getBanner());
        }
        return images;
    }

    @Override
    protected void initView() {
        /*mBannerView.setAdapter(new AdBannerAdapter() {
            @Override
            public int getCount() {
                // 返回多少条
                return items.length;
            }

            @Override
            public String getImageUrl(int position) {
                // 根据不同返回当前路径
                return items[position];
            }
        });

        mBannerView.startRoll();*/
    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_banner_test);
    }
}
