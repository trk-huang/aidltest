// IMyAidlInterface.aidl
package com.zhiping.alibaba.aidltest;

// Declare any non-default types here with import statements

import com.zhiping.alibaba.aidltest.Food;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    Food danner();
    void setFood(in Food food);
}
