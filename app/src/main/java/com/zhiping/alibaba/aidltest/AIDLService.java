package com.zhiping.alibaba.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by huangdaju on 17/8/8.
 */

public class AIDLService extends Service {

    private Binder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public Food danner() throws RemoteException {
            System.out.println("亲爱的，晚上想吃点啥");

            Food food = new Food();
            food.setName("花椰菜111");
            food.setPrice(1.6f);
            return food;
        }

        @Override
        public void setFood(Food food) throws RemoteException {

            System.out.println("亲爱的，晚上想吃点啥: " + food.toString());
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


}
