package com.zhiping.alibaba.clienttest;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.zhiping.alibaba.aidltest.Food;
import com.zhiping.alibaba.aidltest.IMyAidlInterface;

/**
 * Created by huangdaju on 17/8/8.
 */

public class MyServiceConnection implements ServiceConnection {

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
