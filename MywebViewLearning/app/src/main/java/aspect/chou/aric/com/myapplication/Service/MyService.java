package aspect.chou.aric.com.myapplication.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import aspect.chou.aric.com.myapplication.IMyAidlInterface;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mIBinder;
    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public int add(int number1, int number2) throws RemoteException {
            return number1+number2;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }

    };

}
