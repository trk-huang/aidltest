package com.zhiping.alibaba.aidltest;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by huangdaju on 17/8/8.
 */

public class AidlServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        try {
            Food food = new Food();
            food.setName("花椰菜");
            food.setPrice(1.5f);
            iMyAidlInterface.setFood(food);
            Food food1 = iMyAidlInterface.danner();
            System.out.println("food1:" + food1.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
