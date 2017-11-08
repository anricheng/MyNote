package aspect.chou.aric.com.myapplication;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.json.JSONObject;


public class AndroidToJS {

    private Context mContext;
    private static final String TAG = "AndroidToJS";

    JSONObject jsonObject;

    public AndroidToJS(Context context) {
        this.mContext=context.getApplicationContext();
    }

    public AndroidToJS(Context context, JSONObject jsonObject) {
        mContext = context;
        this.jsonObject = jsonObject;
    }

    @JavascriptInterface
    public void hello(String msg) {

        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();

    }

    @JavascriptInterface
    public JSONObject sendDataToJs(){

        return jsonObject;

    };


}
