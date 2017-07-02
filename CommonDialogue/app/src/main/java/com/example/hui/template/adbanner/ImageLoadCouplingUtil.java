package com.example.hui.template.adbanner;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * ============================================================
 *
 * copyright ZENG　HUI (c) 2014
 *
 * author : HUI
 *
 * version : 1.0
 *
 * date created : On November 24, 2014 9:14:37
 *
 * description : 图片加载的耦合工具类
 *
 * revision history :
 *
 * ============================================================
 */
public class ImageLoadCouplingUtil {
    private static ImageLoadCouplingUtil mInstance;

    private static int mErrorResource;

    public static void initErrorResouce(int errorResouce) {
        mErrorResource = errorResouce;
    }

    private ImageLoadCouplingUtil() {

    }

    public static ImageLoadCouplingUtil getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoadCouplingUtil.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoadCouplingUtil();
                }
            }
        }
        return mInstance;
    }

    /**************************
     * 本地文件图片加载
     ****************************/
    public void loadImage(File file, ImageView imageView) {
        Glide.with(imageView.getContext()).load(file).error(mErrorResource)
                .into(imageView);
    }

    public void loadImage(File file, ImageView imageView, int errorResource) {
        Glide.with(imageView.getContext()).load(file).error(errorResource)
                .into(imageView);
    }

    /**************************
     * 本地资源图片加载
     ****************************/
    public void loadImage(int resourceId, ImageView imageView) {
        Glide.with(imageView.getContext()).load(resourceId).error(mErrorResource)
                .into(imageView);
    }

    public void loadImage(int resourceId, ImageView imageView, int errorResource) {
        Glide.with(imageView.getContext()).load(resourceId).error(errorResource)
                .into(imageView);
    }

    /**************************
     * url图片加载
     ****************************/
    public void loadImage(String url, ImageView imageView) {
        display(url, imageView, mErrorResource);
    }

    public void loadImage(String url, ImageView imageView, int errorResource) {
        display(url, imageView, errorResource);
    }

    private void display(String url, ImageView imageView, int errorResource) {
        Glide.with(imageView.getContext()).load(url).error(errorResource)
                .into(imageView);
    }
}
