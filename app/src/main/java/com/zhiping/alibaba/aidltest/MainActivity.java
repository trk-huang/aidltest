package com.zhiping.alibaba.aidltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ʹ��Messenger���н���ͨ��
//        Intent intent = new Intent(this, ServerService.class);
//        MyServiceConnection serviceConnection = new MyServiceConnection();
//        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
        //ʹ��AIDL���н���ͨ��
//        Intent intent = new Intent(this, AIDLService.class);
//        AidlServiceConnection aidlServiceConnection = new AidlServiceConnection();
//        bindService(intent, aidlServiceConnection, BIND_AUTO_CREATE);
    }
}
