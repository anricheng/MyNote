package aspect.chou.aric.com.myapplication;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLinearLayoutContainer;

    private  WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayoutContainer= ((LinearLayout) findViewById(R.id.ll_container));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        mWebView = new WebView(this.getApplication());
        mWebView.setLayoutParams(layoutParams);
        mLinearLayoutContainer.removeView(mLinearLayoutContainer);
        mLinearLayoutContainer.addView(mWebView);


        WebSettings webSettings = mWebView.getSettings();


        webSettings.setJavaScriptEnabled(true);

        String name = getIntent().getStringExtra(SplashActivity.NAME);

        String vinCode=getIntent().getStringExtra(SplashActivity.MVINCODE);

        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        UserInfo userInfo = new UserInfo(name,vinCode);




        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                if(request.getUrl().toString()!=""){
                    view.loadUrl(request.getUrl().toString());   //在当前的webview中跳转到新的url
                }
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url!=""){
                    view.loadUrl(url);   //在当前的webview中跳转到新的url
                    System.out.println("url:"+url);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {


                Log.e("onPageFinished","onPageFinished");

                super.onPageFinished(view, url);
                if (Build.VERSION.SDK_INT<=18){
                    mWebView.loadUrl("javascript:callJS()");
                }else {

                    mWebView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {

                        }
                    });

                }
            }
        });

        mWebView.addJavascriptInterface(userInfo, "android");
        mWebView.loadUrl("file:///android_asset/html/test.html");

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

//
//        @Override
//        protected void onDestroy() {
//            if( mWebView!=null) {
//
//                // 如果先调用destroy()方法，则会命中if (isDestroyed()) return;这一行代码，需要先onDetachedFromWindow()，再
//                // destory()
//                ViewParent parent = mWebView.getParent();
//                if (parent != null) {
//                    ((ViewGroup) parent).removeView(mWebView);
//                }
//
//                mWebView.stopLoading();
//                // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
//                mWebView.getSettings().setJavaScriptEnabled(false);
//                mWebView.clearHistory();
//                mWebView.clearView();
//                mWebView.removeAllViews();
//                mWebView.destroy();
//
//            }
//            super.on Destroy();
//        }


    }

    @Override
    public void onBackPressed() {

        if (mWebView.canGoBack()){
            mWebView.goBack();
        }else {
            super.onBackPressed();
        }

    }


}
