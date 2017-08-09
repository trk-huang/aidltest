package com.zhiping.alibaba.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by huangdaju on 17/8/8.
 */

public class ServerService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    final  Messenger mMessenger = new Messenger(mHandler);
    private final static  Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String value = bundle.getString("key");
            System.out.println("0101，我收到你的话了：" + value);
            System.out.println("0101，我是1号，我是1号，收到请回话，收到请回话");
            Messenger messenger = msg.replyTo;
            Message msg_replyto = Message.obtain();
            Bundle data = new Bundle();
            data.putString("key","0101，我❤你，too");
            msg_replyto.setData(data);
            try {
                messenger.send(msg_replyto);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
    };


}
