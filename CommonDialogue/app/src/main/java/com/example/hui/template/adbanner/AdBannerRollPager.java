package com.example.hui.template.adbanner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;


/**
 * ============================================================
 * <p/>
 * project name : DiDi professor
 * <p/>
 * copyright : ZENG HUI (c) 2014
 * <p/>
 * author : HUI
 * <p/>
 * email : 240336124@QQ.com
 * <p/>
 * version : 1.0
 * <p/>
 * date created : On February 14, 2015 13:32:31
 * <p/>
 * description : 自定义导航条
 * <p/>
 * revision history :
 * <p/>
 * ============================================================
 */
public class AdBannerRollPager extends ViewPager {
    private Context mContext;
    // 点的集合
    private ViewGroup mDotsContanier;
    /**
     * 当前广告的描述
     **/
    private TextView mCurrentAdvertisingDesc;

    // 当前点的位置
    private int mCurrentPosition = 0;
    // 滚动的message what
    private final int ROLL_MESSAGE_WHAT = 1;
    // 页面切换的间隔时间
    private int mTimeIntervalBetween = 4000;
    /**
     * 选择点的背景图片
     **/
    private Drawable mDotFocus;
    /**
     * 其他点的背景图片
     **/
    private Drawable mDotNormal;
    // 数据适配
    private AdBannerAdapter mAdapter;

    // 广告条条目点击位置的监听
    public BannerItemClickListener mBannerItemClickListener;

    public void setOnBannerItemClickListener(
            BannerItemClickListener bannerItemClickistener) {
        this.mBannerItemClickListener = bannerItemClickistener;
    }

    public interface BannerItemClickListener {
        void clickItem(int position);
    }

    /**
     * 广告条的构造函数
     *
     * @param context
     */
    public AdBannerRollPager(Context context, ViewGroup dotsContainer,
                             Drawable dotFocus, Drawable dotNormal) {
        super(context);
        this.mContext = context;
        this.mDotsContanier = dotsContainer;
        this.mDotFocus = dotFocus;
        this.mDotNormal = dotNormal;
    }

    /**
     * 设置广告位的描述和集合
     *
     * @param currentAdvertisingDesc
     */
    public void setTitleDesc(TextView currentAdvertisingDesc) {
        this.mCurrentAdvertisingDesc = currentAdvertisingDesc;
    }

    /**
     * 定时器监听
     */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            cycleRollBanner();
        }
    };

    /**
     * 循环滚动
     */
    public void cycleRollBanner() {
        this.setCurrentItem(mCurrentPosition + 1);
        startRollBanner();
    }

    /**
     * 设置条目切换的间隔时间
     */
    public void setTimeIntervalBetween(int timeIntervalBetween) {
        this.mTimeIntervalBetween = timeIntervalBetween;
    }

    /**
     * 开始滚动
     */
    public void startRollBanner() {
        mHandler.removeMessages(ROLL_MESSAGE_WHAT);
        mHandler.sendEmptyMessageDelayed(ROLL_MESSAGE_WHAT,
                mTimeIntervalBetween);
    }

    /**
     * 停止滚动
     */
    public void stopRollBanner() {
        mHandler.removeMessages(ROLL_MESSAGE_WHAT);
    }

    /**
     * 设置ViewPager的Adapter
     */
    private void setViewPagerAdapter() {
        NavigationRollViewPagerAdapter adapter = new NavigationRollViewPagerAdapter();
        this.setAdapter(adapter);
        addOnPageChangeListener(new BannerRollViewPagerChangeListener());
    }

    private class NavigationRollViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public Object instantiateItem(View container, final int position) {
            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            ((ViewPager) container).addView(imageView);
            if (mBannerItemClickListener != null) {
                imageView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBannerItemClickListener.clickItem(position
                                % mDotsContanier.getChildCount());
                    }
                });
            }

            // 不断的根据路径加载图片
            ImageLoadCouplingUtil.getInstance().loadImage(mAdapter.getImageUrl
                    (position % mAdapter.getCount()), imageView);

            return imageView;
        }

        /**
         * 如果一致可以复用
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 销毁该条目
         */
        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
            object = null;
        }
    }

    public class BannerRollViewPagerChangeListener implements
            OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {// 监听了ViewPager滚动  position 0 1 2
            // 设置点的滚动背景
            if (mDotsContanier != null && mAdapter.getCount() > 0) {
                int currentPosition = position % mAdapter.getCount();

                ((ImageView) mDotsContanier.getChildAt(currentPosition)).setImageDrawable(
                        mDotFocus);
                ((ImageView) mDotsContanier.getChildAt(
                        mCurrentPosition % mAdapter.getCount())).setImageDrawable(
                        mDotNormal);
            }
            mCurrentPosition = position;
            // 广告位描述
            String adDescStr = mAdapter.getTitleDesc(position
                    % mAdapter.getCount());
            if (!TextUtils.isEmpty(adDescStr)) {
                mCurrentAdvertisingDesc.setText(adDescStr);
            }
        }
    }

    // 设置数据适配器
    public void setAdapter(AdBannerAdapter adapter) {
        if (adapter == null) {
            throw new RuntimeException("adapter is null...");
        }
        this.mAdapter = adapter;
        setViewPagerAdapter();
    }
}
