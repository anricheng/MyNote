package com.example.hui.template.adbanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hui.template.R;

import java.lang.reflect.Field;

import de.hdodenhof.circleimageview.CircleImageView;


public class AdBannerRollPagerView extends RelativeLayout implements
        OnTouchListener {
    private Context mContext;
    /**
     * 滚动的view pager
     **/
    private AdBannerRollPager mViewPager;
    /**
     * 所有点的容器
     **/
    private LinearLayout mDotsContainer;
    /**
     * 所有条目view pager 的容器
     **/
    private LinearLayout mViewPagerContainer;
    /**
     * 当前广告的描述
     **/
    private TextView mCurrentAdvertisingDesc;
    /**
     * 选择点的背景图片
     **/
    private Drawable mDotFocus;
    /**
     * 其他点的背景图片
     **/
    private Drawable mDotNormal;
    /**
     * item切换持续的时间
     **/
    private int mItemCutDuration = 350;
    /**
     * 多久切换到下一item
     **/
    private int mItemCutByDuration = 4000;

    private float mWidthPro; // 宽度比例
    private float mHeightPro; // 高度比例
    // 数据适配
    private AdBannerAdapter mAdapter;

    public AdBannerRollPagerView(Context context) {
        this(context, null);
    }

    public AdBannerRollPagerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdBannerRollPagerView(Context context, AttributeSet attrs,
                                 int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        initView();
        initAttributeSet(attrs);
    }

    /**
     * 初始化属性值
     *
     * @param attrs
     */
    private void initAttributeSet(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs,
                R.styleable.adBannerRollView);
        mDotFocus = array
                .getDrawable(R.styleable.adBannerRollView_dotFocusBackGround);
        mDotNormal = array
                .getDrawable(R.styleable.adBannerRollView_dotNormalBackground);

        if (mDotFocus == null) {
            mDotFocus = new ColorDrawable(Color.RED);
        }

        if (mDotNormal == null) {
            mDotNormal = new ColorDrawable(Color.WHITE);
        }

        mWidthPro = array.getFloat(
                R.styleable.adBannerRollView_widthProportion, mWidthPro);
        mHeightPro = array.getFloat(
                R.styleable.adBannerRollView_heightProportion, mHeightPro);

        int dotLocation = array.getInt(
                R.styleable.adBannerRollView_dotLocation, 2);

        switch (dotLocation) {
            case 0:
                mDotsContainer.setGravity(Gravity.CENTER);
                break;
            case 1:
                mDotsContainer.setGravity(Gravity.LEFT);
                break;
            case 2:
                mDotsContainer.setGravity(Gravity.RIGHT);
                break;
        }
        array.recycle();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        // 加载布局到该 View
        View.inflate(mContext, R.layout.ui_advertising_banner, this);
        mDotsContainer = (LinearLayout) findViewById(R.id.dots_ll);
        mCurrentAdvertisingDesc = (TextView) findViewById(R.id.banner_title);
        mViewPagerContainer = (LinearLayout) findViewById(R.id.top_news_viewpager);
    }

    /**
     * 点的显示位置枚举
     */
    public enum DotLocation {
        RIGHT, CENTER, LEFT
    }

    /**
     * 设置页面切换的持续时间
     *
     * @param itemCutDuration
     */
    public void setItemCutDuration(int itemCutDuration) {
        this.mItemCutDuration = itemCutDuration;
    }

    /**
     * 设置多久切换到下一个item
     *
     * @param itemCutByDuration
     */
    public void setItemCutByDuration(int itemCutByDuration) {
        this.mItemCutByDuration = itemCutByDuration;
    }

    /**
     * 初始化滚动 view pager
     */
    private void initRollViewPager() {
        mViewPager = new AdBannerRollPager(mContext, mDotsContainer, mDotFocus,
                mDotNormal);
        mViewPager.setOnTouchListener(this);
        mViewPager.setTitleDesc(mCurrentAdvertisingDesc);

        try {
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            FixedSpeedScroller mScroller = new FixedSpeedScroller(mContext,
                    new AccelerateInterpolator());
            // Can adjust the rate in setDuration way
            // 控制ViewPager切换的速率
            mScroller.setmDuration(mItemCutDuration);
            mField.set(mViewPager, mScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mViewPager.setTimeIntervalBetween(mItemCutByDuration);
        mViewPagerContainer.removeAllViews();
        mViewPagerContainer.addView(mViewPager);

        mViewPager.setAdapter(mAdapter);
    }

    /**
     * 开始滚动
     */
    public void startRoll() {
        mViewPager.startRollBanner();
    }

    /**
     * 停止滚动
     */
    public void stopRoll() {
        mViewPager.stopRollBanner();
    }

    /**
     * 初始化点集合
     */
    private void initDot(int size) {
        mDotsContainer.removeAllViews();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    dip2px(mContext, 7), dip2px(
                    mContext, 7));
            params.setMargins(5, 0, 5, 0);
            CircleImageView m = new CircleImageView(mContext);
            if (i == 0) {
                m.setImageDrawable(mDotFocus);
            } else {
                m.setImageDrawable(mDotNormal);
            }
            m.setLayoutParams(params);
            mDotsContainer.addView(m);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                stopRoll();
                break;
            case MotionEvent.ACTION_UP:
                startRoll();
                break;
        }
        return false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mWidthPro != 0 && mHeightPro != 0) {
            // 拿到宽
            int width = MeasureSpec.getSize(widthMeasureSpec);
            // 根据宽高比计算高度
            int mHeight = (int) (width * (mHeightPro / mWidthPro));
            // 设置高度
            this.getLayoutParams().height = mHeight;
        }
    }

    /**
     * 设置点击的监听
     */
    public void setOnBannerItemClickListener(AdBannerRollPager.BannerItemClickListener bannerListener) {
        mViewPager.setOnBannerItemClickListener(bannerListener);
    }

    // 设置数据适配器
    public void setAdapter(AdBannerAdapter adapter) {
        if (adapter == null) {
            throw new RuntimeException("adapter is null...");
        }

        this.mAdapter = adapter;
        // 初始化点
        initDot(mAdapter.getCount());

        initRollViewPager();

        if(!TextUtils.isEmpty(adapter.getTitleDesc(0))){
            mCurrentAdvertisingDesc.setText(adapter.getTitleDesc(0));
        }
    }

    /**
     * Dip into pixels
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
