package com.zhiping.alibaba.clienttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyServiceConnection myServiceConnection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("action.aidltest");
        intent.setPackage("com.zhiping.alibaba.aidltest");
        myServiceConnection = new MyServiceConnection();
        bindService(intent, myServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        if (myServiceConnection != null) {
            unbindService(myServiceConnection);
            myServiceConnection = null;
        }
        super.onDestroy();

    }
}
