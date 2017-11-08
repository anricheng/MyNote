package aspect.chou.aric.com.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayoutContainer;

    private  WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayoutContainer= ((LinearLayout) findViewById(R.id.ll_container));

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0);


        mWebView = new WebView(this.getApplication());

        layoutParams.weight=1.0f;


        mWebView.setLayoutParams(layoutParams);
        mLinearLayoutContainer.removeView(mLinearLayoutContainer);


        mLinearLayoutContainer.addView(mWebView);


        WebSettings webSettings = mWebView.getSettings();


        webSettings.setJavaScriptEnabled(true);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        Student student = new Student("zhou","12");

        Gson gson = new Gson();

        JSONObject jsonObject=null;

        String studentgson = gson.toJson(student);
        try {
             jsonObject = new JSONObject(studentgson);
        }catch (Exception e){

        }


        mWebView.addJavascriptInterface(new AndroidToJS(this.getApplication(), jsonObject), "android");


        mWebView.loadUrl("file:///android_asset/test.html");



        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }

        });


    }

    public  void callJs(View view){

        mWebView.post(new Runnable() {
                    @Override
                    public void run() {

//                        // Android版本变量
//                        final int version = Build.VERSION.SDK_INT;
//// 因为该方法在 Android 4.4 版本才可使用，所以使用时需进行版本判断
//                        if (version < 18) {
//                            mWebView.loadUrl("javascript:callJS()");
//                        } else {
//                            mWebView.evaluateJavascript（"javascript:callJS()", new ValueCallback<String>() {
//                                @Override
//                                public void onReceiveValue(String value) {
//                                    //此处为 js 返回的结果
//                                }
//                            });
//                        }

                        Student student = new Student("zhou","12");

                        Gson gson = new Gson();

                        JSONObject jsonObject=null;

                        String studentgson = gson.toJson(student);
                        try {
                            jsonObject = new JSONObject(studentgson);
                        }catch (Exception e){

                        }

                        // 注意调用的JS方法名要对应上
                        // 调用javascript的callJS()方法
                        mWebView.loadUrl("javascript:callJS("+studentgson+")");
                    }
                });

            }


    @Override
    protected void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }
    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.clearCache(true); //清空缓存
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                if (mLinearLayoutContainer != null) {
                    mLinearLayoutContainer.removeView(mWebView);
                }
                mWebView.removeAllViews();
                mWebView.destroy();
            }else {
                mWebView.removeAllViews();
                mWebView.destroy();
                if (mLinearLayoutContainer != null) {
                    mLinearLayoutContainer.removeView(mWebView);
                }
            }
            mWebView = null;
        }

        super.onDestroy();
    }



}
