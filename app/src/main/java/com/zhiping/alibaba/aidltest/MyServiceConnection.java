package com.zhiping.alibaba.aidltest;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/**
 * Created by huangdaju on 17/8/8.
 */

public class MyServiceConnection implements ServiceConnection {

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        final Messenger messenger = new Messenger(service);
        final Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("key", "i love you, mxy");
        msg.setData(bundle);
        msg.replyTo = mMessenger;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        messenger.send(msg);
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }


    private Messenger mMessenger = new Messenger(mHandler);
    private static final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("1号，1号，我是0101，我已收到消息");
            Bundle bundle = msg.getData();
            System.out.println("我已收到消息: " + bundle.getString("key"));
        }
    };
}
