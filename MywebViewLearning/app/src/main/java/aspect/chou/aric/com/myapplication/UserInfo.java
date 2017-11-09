package aspect.chou.aric.com.myapplication;

import android.content.Context;
import android.webkit.JavascriptInterface;


public class UserInfo {

    private Context mContext;
    private static final String TAG = "UserInfo";

    String username;
    String vincode;

    String vehicleNumber;

    @JavascriptInterface
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public UserInfo(Context context, String username, String vincode) {
        mContext = context;
        this.username = username;
        this.vincode = vincode;
    }

    public UserInfo(String username, String vincode) {
        this.username = username;
        this.vincode = vincode;
    }

    @JavascriptInterface
    public void hello(String msg) {

        vehicleNumber=msg;

    }

    @JavascriptInterface
    public String getUsername(){

        return username;

    };


    @JavascriptInterface
    public String getVincode(){

        return vincode;

    };

}
