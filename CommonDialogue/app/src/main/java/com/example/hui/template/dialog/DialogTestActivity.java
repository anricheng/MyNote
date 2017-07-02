package com.example.hui.template.dialog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.hui.template.R;
import com.example.hui.template.design.mode.BaseActivity;
import com.example.hui.template.ioc.view.OnClick;
import com.example.hui.template.ioc.view.ViewById;
import com.example.hui.template.titlebar.CommonTitleBar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * description：
 * <p>
 * Created by 曾辉 on 2016/6/30 22:35
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
public class DialogTestActivity extends BaseActivity {
    private static final int ALBUM_OK = 0x0011;

    private static final int IMAGE_CUT = 0x0022;

    private static final int CAMERA_REQUEST = 0x0033;

    @ViewById(R.id.user_header_iv)
    private CircleImageView mUserHeaderIv;

    private File tempFile;// 拍照之后相片存放的路径

    @Override
    protected void initTitle(CommonTitleBar titleBar) {

        ListPopupWindow  pop  = new ListPopupWindow(this);
        pop.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"hai","feng"}));

    }

    @Override
    protected void initData() {
        // Environment.getExternalStorageDirectory() 获取手机的根目录
        tempFile = new File(Environment.getExternalStorageDirectory(),"temp.png");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setRootView() {
        setContentView(R.layout.activity_dialog_test);
    }


    @OnClick(R.id.user_header_iv)
    private void userHeaderClick() {
        // 任务 天天防腐上传图片  布局  高度是屏幕的  65%  能够拍照和选择图片 即可    上传服务器
        CommonDialog.Builder builder = new CommonDialog.Builder(DialogTestActivity.this);
        builder.setView(R.layout.photo_choose_dialog).showAnimation(R.style.dialog_scale_animstyle);

        final CommonDialog dialog = builder.create();
        dialog.show();

        dialog.setText(R.id.user_cancel,"CANCEL");
        dialog.setOnClickListener(R.id.user_cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        /*// 弹出自定义的Dialog
        // Toast.makeText(this,"弹出自定义的Dialog",Toast.LENGTH_LONG).show();

        // 原生的实现方式
        // 1. Dialog 对象
        // Dialog dialog = new Dialog(this);


        // 4.处理头部    给自定义的Theme  给主题指定没有头部
        // Dialog(@NonNull Context context, @StyleRes int themeResId)
        final Dialog dialog = new Dialog(this, R.style.dialog);

        // 2.设置布局View
        View dialogView = View.inflate(this, R.layout.photo_choose_dialog, null);
        dialog.setContentView(dialogView);

        // 5.从底部弹出  动画
        Window window = dialog.getWindow();
        // 设置动画
        window.setWindowAnimations(R.style.main_menu_animstyle);
        // 固定在底部
        window.setGravity(Gravity.BOTTOM);

        // 6.设置宽度全屏
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // 7.设置点击事件  R.id.user_cancel 的布局在哪里？  自定义View   设计模式 不会用到代码中
        dialogView.findViewById(R.id.user_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 关闭Dialog
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.image_depot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 从手机中选择  跳转到手机相册
                // 选择照片   利用系统   隐示意图
                Intent albumIntent = new Intent(Intent.ACTION_PICK);
                // 匹配类型 只需要匹配一个就可以了
                albumIntent.setType("image*//*");
                // 为什么不是直接开启  选完相片之后 startActivityForResult 需要获取图片信息
                startActivityForResult(albumIntent, ALBUM_OK);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.photo_camre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 调用相机去拍照
                Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                // MediaStore.EXTRA_OUTPUT 调用系统拍完之后的照片，就会放到这个tempFile文件
                getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                startActivityForResult(getImageByCamera, CAMERA_REQUEST);
                dialog.dismiss();
            }
        });

        // 3.显示看一下效果
        dialog.show();*/
    }

    /**
     * requestCode int   resultCode int   data数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {// RESULT_OK  -1   可以不判断
            switch (requestCode) {
                case ALBUM_OK:
                    // 这个代表选择图片吧 拿图片  设置给ImageView
                    Uri uri = data.getData();
                    // 从uri里面获取图片  用户图像肯定需要裁剪  并且比例是 1：1
                    startPhotoZoom(uri);
                    break;

                case CAMERA_REQUEST:
                    // 图片 tempFile  裁剪
                    startPhotoZoom(Uri.fromFile(tempFile));
                    break;

                case IMAGE_CUT:
                    // 获取裁剪的图片数据
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        Bitmap bitmap = extras.getParcelable("data");
                        // 设置图片
                        mUserHeaderIv.setImageBitmap(bitmap);

                        // 上传图片到服务器  提交的是File  1.bitmap-File  2.调用接口上传文件到服务器
                        saveBitmapToFile(bitmap,tempFile);

                        // 上传 tempFile
                    }
                    break;
            }
        }
    }

    private void saveBitmapToFile(Bitmap bitmap, File tempFile) {
        // compress(CompressFormat format, int quality, OutputStream stream)
        // quality 压缩的质量   100
        try {
            OutputStream os = new FileOutputStream(tempFile);

            bitmap.compress(Bitmap.CompressFormat.PNG,100,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);// getIntent.getInt("aspectX")
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, IMAGE_CUT);
    }
}
