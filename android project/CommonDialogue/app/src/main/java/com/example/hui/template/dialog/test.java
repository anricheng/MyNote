/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.hui.template.dialog;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * com.example.hui.template.dialog
 * Created by Aric on 下午7:18.
 */

public class test implements Parcelable {

    private  String zhu;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.zhu);
    }

    public test() {
    }

    protected test(Parcel in) {
        this.zhu = in.readString();
    }

    public static final Parcelable.Creator<test> CREATOR = new Parcelable.Creator<test>() {
        @Override
        public test createFromParcel(Parcel source) {
            return new test(source);
        }

        @Override
        public test[] newArray(int size) {
            return new test[size];
        }
    };
}
